package com.andyadc.tinyspring.beans;

/**
 * 定义 Bean 异常
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
