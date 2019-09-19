package com.xiaoran.infrastructure.springs;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName CommandHandlerDefinitionRegistry
 * Description TODO
 * Author xiaoran
 * Date 2019/9/17 17:17
 * Version 1.0
 **/
public class CommandHandlerDefinitionRegistry implements ImportBeanDefinitionRegistrar, BeanFactoryAware {


    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        BeanDefinition beanDefinition= BeanDefinitionBuilder.rootBeanDefinition(AnnotationCommandHandlerBeanProcessor.class).getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("annotationCommandHandlerBeanProcessor",beanDefinition);

        BeanDefinition beanDefinition2= BeanDefinitionBuilder.rootBeanDefinition(CommandHandlerPostProcesser.class).getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("commandHandlerSubscriber",beanDefinition2);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=(ConfigurableListableBeanFactory)beanFactory;
    }


}
