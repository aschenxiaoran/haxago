package com.xiaoran.infrastructure.springs;

import com.xiaoran.infrastructure.command.CommandMessage;
import com.xiaoran.infrastructure.config.annotation.CommandHandler;
import com.xiaoran.infrastructure.config.annotation.MethodCommandHandler;
import com.xiaoran.infrastructure.exception.InvalidCommandCountException;
import com.xiaoran.infrastructure.exception.MethodComandHandlerException;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName Description TODO
 * Author xiaoran
 * Date 2019/9/19 21:05
 * Version 1.0
 **/
public class CommandBus {

    //region private variables

    private final static Integer COMMAND_COUNT = 1;
    private Map<String, MethodCommandHandler> methodCommandHandlerHolder = new ConcurrentHashMap<>();

    //endregion

    //region ctor

    //endregion

    //region public methods

    public void subscribe(Object bean) {

        Method[] declaredMethods = bean.getClass().getDeclaredMethods();

        Arrays.stream(declaredMethods).filter(method -> method.isAnnotationPresent(CommandHandler.class))
                .forEach(handlerMethod -> {

                    String commandName = getMethodParaterName(handlerMethod);
                    MethodCommandHandler commandHandler = new MethodCommandHandler(bean.getClass(), handlerMethod);
                    methodCommandHandlerHolder.put(commandName, commandHandler);
                });
    }

    public void dispatch(CommandMessage commmandMessage) {

        String commandName = commmandMessage.getClass().getName();
        MethodCommandHandler methodCommandHandler = methodCommandHandlerHolder.get(commandName);

        if (methodCommandHandler == null) {
            throw new MethodComandHandlerException(String.format("%s can not find comand handler", commmandMessage));
        }

        try {
            Class<?> aggragateRoot = Class.forName(methodCommandHandler.getAggrateRootClass().getName());
            methodCommandHandler.getHandlerMethod().invoke(aggragateRoot.newInstance(), commmandMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //endregion

    //region private methods

    private String getMethodParaterName(Method handlerMethod) {
        Class<?>[] paramterTypes = handlerMethod.getParameterTypes();

        if (invalidCommandParameterCount(paramterTypes)) {
            throw new InvalidCommandCountException("command paramters count must be" + COMMAND_COUNT);
        }

        return paramterTypes[0].getName();
    }

    private boolean invalidCommandParameterCount(Class<?>[] paramterTypes) {
        return paramterTypes.length != COMMAND_COUNT;
    }


    //endregion


}
