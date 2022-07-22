package com.cjj.service;

import com.spring.BeanPostProcessor;
import com.spring.Componet;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
@Componet
public class CjjPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("初始化前");
        if(bean.equals("userService"))
        {
            ((UserService) bean).setName("cjj");
        }

        return null;
    }

    @Override
    public Object postProcessAftereInitialization(Object bean, String beanName) {
        System.out.println("初始化后");
        return bean;
    }
}
