package com.andyadc.tinyspring.beans.factory;

import com.andyadc.tinyspring.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;
}
