package com.cjj.service;

import com.spring.Autowired;
import com.spring.Componet;
import com.spring.InitializingBean;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
@Componet("orderService")
//@Scope("prototype")//原型Bean
public class OrderService implements InitializingBean {
    @Autowired
    private UserService userService;
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }
}
