package com.andyadc.tinyspring.beans.factory.support;

import com.andyadc.tinyspring.beans.BeansException;
import com.andyadc.tinyspring.beans.PropertyValue;
import com.andyadc.tinyspring.beans.PropertyValues;
import com.andyadc.tinyspring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    //    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor<?> constructor = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (args != null && declaredConstructor.getParameterTypes().length == args.length) {
                constructor = declaredConstructor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
    }

    /**
     * Bean 属性填充
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
