package com.andyadc.tinyspring.beans.factory.support;

import com.andyadc.tinyspring.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     */
    void register(String beanName, BeanDefinition beanDefinition);
}
