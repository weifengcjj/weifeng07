package com.cjj.View;

import com.cjj.service.UserService;
import com.spring.ApptionContexy;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */

public class Test {
    public static void main(String[] args) {
        ApptionContexy apptionContexy=new ApptionContexy(Appconfig.class);
        //Object userservice=apptionContexy.getBean("userService");//map <beanName,bean对象>
//        System.out.println(apptionContexy.getBean("userService"));
//        System.out.println(apptionContexy.getBean("userService"));
//        System.out.println(apptionContexy.getBean("userService"));
        UserService userService = (UserService) apptionContexy.getBean("userService");
        userService.test();
    }
}
