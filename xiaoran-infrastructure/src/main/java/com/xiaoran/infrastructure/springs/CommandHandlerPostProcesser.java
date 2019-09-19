package com.xiaoran.infrastructure.springs;

import com.xiaoran.infrastructure.config.annotation.CommandHandler;
import com.xiaoran.infrastructure.message.MessageHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName CommandHandlerPostProcesser
 * Description TODO
 * Author xiaoran
 * Date 2019/9/19 15:03
 * Version 1.0
 **/
public class CommandHandlerPostProcesser implements BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Map<String,MessageHandler> commandHandlers=applicationContext.getBeansOfType(MessageHandler.class);
        if(commandHandlers.values().isEmpty()){
            System.out.println("CommandHandlerPostProcess数量：0"+beanName);
        }
        System.out.println("CommandHandlerPostProcess数量："+commandHandlers.values().size());
        return bean;
    }
}
