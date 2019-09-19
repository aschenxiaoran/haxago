package com.xiaoran.infrastructure.springs;

import com.xiaoran.infrastructure.CommandGateWay;
import com.xiaoran.infrastructure.aggragate.ProductAggragateRoot;
import com.xiaoran.infrastructure.aggragate.SimpleAggrageRoot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringConfiguration
 * Description TODO
 * Author xiaoran
 * Date 2019/9/17 17:23
 * Version 1.0
 **/
@Configuration
public class SpringConfiguration {

    @Bean
    public CommandHandlerDefinitionRegistry registry(){
        return new CommandHandlerDefinitionRegistry();
    }

    @Bean
    public ProductAggragateRoot productAggragateRoot(){
        return new ProductAggragateRoot();
    }

    @Bean
    public SimpleAggrageRoot simpleAggragateRoot(){
        return new SimpleAggrageRoot();
    }

    @Bean
    public CommandBus commandBus(){
        return new CommandBus();
    }

    @Bean
    public CommandGateWay commandGateWay(){
        return new CommandGateWay(commandBus());
    }
}
