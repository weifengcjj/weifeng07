package com.cjj.service;

import com.spring.Autowired;
import com.spring.BeanNameAware;
import com.spring.Componet;
import com.spring.Scope;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
@Componet("userService")
//@Scope("prototype")//原型Bean
public class UserService implements BeanNameAware {
    @Autowired
    private OrderService orderService;
    private String beanName;

    public void setName(String name) {
        this.name = name;
    }

    private  String name;
    @Override
    public void setBeanNameAware(String name) {
        this.beanName=name;
    }
    public  void test()
    {
        System.out.println(orderService);
        System.out.println(beanName);
        System.out.println(name);
    }


}
