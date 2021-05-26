package com.andyadc.tinyspring.test;

import com.andyadc.tinyspring.beans.factory.config.BeanDefinition;
import com.andyadc.tinyspring.beans.factory.support.DefaultListableBeanFactory;
import com.andyadc.tinyspring.test.bean.UserService;

public class Test {

    public static void main(String[] args) {
        //
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.register("userService", beanDefinition);
        //
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        System.out.println(userService1);
        System.out.println(userService1.hello("java"));

        UserService userService2 = (UserService) beanFactory.getBean("userService");
        System.out.println(userService2);
        System.out.println(userService2.hello("go"));
    }
}
