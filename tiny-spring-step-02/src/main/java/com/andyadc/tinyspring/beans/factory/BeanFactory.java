package com.andyadc.tinyspring.beans.factory;

import com.andyadc.tinyspring.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}
