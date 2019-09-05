package com.xiaoran.infrastructure.config.annotation;

import com.xiaoran.infrastructure.config.AggragateRoot;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @ClassName AggragateRootAnnotationBeanProcessor
 * Description TODO
 * Author xiaoran
 * Date 2019/9/2 17:07
 * Version 1.0
 **/
public class AggragateRootAnnotationBeanProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean,final String beanName) throws BeansException {
        AggragateRoot annotation=bean.getClass().getAnnotation(AggragateRoot.class);
        if(annotation==null){
            return bean;
        }

        return bean;
    }
}
