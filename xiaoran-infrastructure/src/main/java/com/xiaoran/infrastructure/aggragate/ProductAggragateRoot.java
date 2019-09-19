package com.xiaoran.infrastructure.aggragate;

import com.xiaoran.infrastructure.command.CreateUserCommand;
import com.xiaoran.infrastructure.config.AggragateRoot;
import com.xiaoran.infrastructure.config.annotation.CommandHandler;

/**
 * @ClassName ProductAggragateRoot
 * Description TODO
 * Author xiaoran
 * Date 2019/9/19 20:52
 * Version 1.0
 **/
@AggragateRoot
public class ProductAggragateRoot {

    @CommandHandler
    public void excute(CreateUserCommand createUserCommand){

        System.out.println("执行了CreateUserCommand");

    }
}
