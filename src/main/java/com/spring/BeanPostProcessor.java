package com.spring;

/**
 * @Author 微风
 * @Version 1.0.0
 * @StartTime Start
 * @EndTime End
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean,String beanName);
    Object postProcessAftereInitialization(Object bean,String beanName);
}
