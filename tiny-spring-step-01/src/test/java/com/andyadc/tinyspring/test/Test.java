package com.andyadc.tinyspring.test;

import com.andyadc.tinyspring.BeanDefinition;
import com.andyadc.tinyspring.BeanFactory;
import com.andyadc.tinyspring.test.bean.UserService;

public class Test {

    public static void main(String[] args) {
        // 1.初始化 BeanFactory
        BeanFactory factory = new BeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        factory.registerBeanDefinition("userService", beanDefinition);

        // 3.获取bean
        UserService userService = (UserService) factory.getBean("userService");
        String result = userService.hello("world");

        System.out.println(result);
    }
}
