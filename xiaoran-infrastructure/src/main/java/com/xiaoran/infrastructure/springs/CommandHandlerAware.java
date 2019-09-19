package com.xiaoran.infrastructure.springs;

import com.xiaoran.infrastructure.message.MessageHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.SmartLifecycle;

import java.util.Collection;

/**
 * @ClassName CommandHandlerAware
 * Description TODO
 * Author xiaoran
 * Date 2019/9/17 16:37
 * Version 1.0
 **/
public class CommandHandlerAware implements ApplicationContextAware, SmartLifecycle {

    //region private methods

    private boolean started;
    private ApplicationContext applicationContext;
    private Collection<MessageHandler> commandHandlers;

    //endregion

    //region override methods

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void start() {

        System.out.println("执行了CommandHandlerAware初始化工作");

        if (commandHandlers == null) {
            commandHandlers = applicationContext.getBeansOfType(MessageHandler.class).values();
            System.out.println("获取到commandhandler数量：" + commandHandlers.size());
        }

        this.started = true;
    }

    @Override
    public void stop() {

        this.started = false;
    }

    @Override
    public boolean isRunning() {

        return this.started;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("执行了CommandHandlerAware工作stop");
        stop();
        callback.run();
    }

    //endregion
}
