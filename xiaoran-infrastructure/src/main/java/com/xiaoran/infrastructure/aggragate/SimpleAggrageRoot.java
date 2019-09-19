package com.xiaoran.infrastructure.aggragate;

import com.xiaoran.infrastructure.command.SampleCommand;
import com.xiaoran.infrastructure.command.TestCommand;
import com.xiaoran.infrastructure.config.AggragateRoot;
import com.xiaoran.infrastructure.config.annotation.CommandHandler;

/**
 * @ClassName SimpleAggrageRoot
 * Description TODO
 * Author xiaoran
 * Date 2019/9/19 20:55
 * Version 1.0
 **/
@AggragateRoot
public class SimpleAggrageRoot {

    @CommandHandler
    public void testCommandHandlerMethod(SampleCommand command){
        System.out.println("SampleCommand"+command.getCode());
        System.out.println("终于找到你了，并执行了SampleCommand");
    }

    @CommandHandler
    public void testCommandHandlerMethod1(TestCommand command){

        System.out.println("终于找到你了，并执行了TestCommand");
    }
}
