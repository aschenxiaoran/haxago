package com.xiaoran.infrastructure.config.annotation;

import java.lang.reflect.Method;

/**
 * @ClassName Description TODO
 * Author xiaoran
 * Date 2019/9/19 19:37
 * Version 1.0
 **/
public class MethodCommandHandler implements MessageCommandHandler{

    private Class<?> aggrateRootClass;
    private Method handlerMethod;

    public MethodCommandHandler(Class<?> aggragateRootClass, Method handlerMethod) {
        this.aggrateRootClass=aggragateRootClass;
        this.handlerMethod=handlerMethod;
    }

    public Method getHandlerMethod() {
        return handlerMethod;
    }

    public Class<?> getAggrateRootClass() {
        return aggrateRootClass;
    }
}
