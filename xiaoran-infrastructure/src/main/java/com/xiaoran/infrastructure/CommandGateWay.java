package com.xiaoran.infrastructure;

import com.xiaoran.infrastructure.command.CommandMessage;
import com.xiaoran.infrastructure.config.AggragateRoot;
import com.xiaoran.infrastructure.config.annotation.CommandHandler;
import com.xiaoran.infrastructure.springs.CommandBus;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName CommandGateWay
 * Description TODO
 * Author xiaoran
 * Date 2019/9/17 14:20
 * Version 1.0
 **/
public class CommandGateWay {

    //region private variables

    private CommandBus commandBus;

    //endregion

    //region ctor

    public CommandGateWay(CommandBus commandBus) {
        this.commandBus = commandBus;
    }


    //endregion

    public Response send(CommandMessage command) {

        String commandName = command.getClass().getName();
        String packageName = command.getClass().getPackage().getName();

        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> typeAnnotations = reflections.getTypesAnnotatedWith(AggragateRoot.class);

        for (Class clazz : typeAnnotations) {
            Method[] methods = clazz.getDeclaredMethods();
            Map<Class, Method> methodMap = new ConcurrentHashMap<>();

            Arrays.stream(methods).filter(method -> method.isAnnotationPresent(CommandHandler.class))
                    .forEach(method -> {
                        Arrays.stream(method.getParameterTypes())
                                .forEach(param -> methodMap.put(clazz, method));

                    });

            System.out.println(methodMap.size());
            for (Map.Entry<Class, Method> methodEntry : methodMap.entrySet()) {
                try {
                    Class[] paraTypes = methodEntry.getValue().getParameterTypes();

                    for (Class paraClass : paraTypes) {

                        /* if (commandName.equals(paraClass.getName())) {*/
                        try {
                            methodEntry.getValue().invoke(Class.forName(clazz.getName()).newInstance(), command);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        /*}*/

                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        }

        return null;
    }

    public Response sendAsyc(CommandMessage commmandMessage){
        Response response=new Response();

        commandBus.dispatch(commmandMessage);

        return response;

    }
}
