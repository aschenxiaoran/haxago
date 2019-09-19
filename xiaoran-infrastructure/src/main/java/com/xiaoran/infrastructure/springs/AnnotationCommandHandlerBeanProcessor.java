package com.xiaoran.infrastructure.springs;

import com.xiaoran.infrastructure.aggragate.ProductAggragateRoot;
import com.xiaoran.infrastructure.config.AggragateRoot;
import com.xiaoran.infrastructure.config.annotation.CommandHandler;
import com.xiaoran.infrastructure.config.annotation.MethodCommandHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName AnnotationCommandHandlerBeanProcessor
 * Description TODO
 * Author xiaoran
 * Date 2019/9/17 13:52
 * Version 1.0
 **/
public class AnnotationCommandHandlerBeanProcessor implements BeanPostProcessor, BeanFactoryAware {

    //region private variables

    private BeanFactory beanFactory;
    private CommandBus commandBus;


    //endregion

    //region ctor

    public AnnotationCommandHandlerBeanProcessor(CommandBus commandBus) {
        this.commandBus = commandBus;
    }


    //endregion

    //region override methods

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof ProductAggragateRoot) {
            System.out.println("执行了ProductAggragateRoot的aggrageteroot");
        }

        if (!isAggraterootAnnoationClass(bean)) {
            return bean;
        }

        System.out.println("执行了AnnotationCommandHandlerBeanProcessor中的aggrageteroot");

        commandBus.subscribe(bean);




        return bean;
    }

    /**
     * @param bean
     * @return
     */
    private boolean isAggraterootAnnoationClass(Object bean) {

        AggragateRoot aggragateRoot = bean.getClass().getAnnotation(AggragateRoot.class);

        return null != aggragateRoot;
    }
    //endregion
}
