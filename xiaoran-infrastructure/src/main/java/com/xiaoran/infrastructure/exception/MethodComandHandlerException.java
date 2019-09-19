package com.xiaoran.infrastructure.exception;

/**
 * @ClassName MethodComandHandlerException
 * Description 找不到对应的Command Handler exception
 * Author xiaoran
 * Date 2019/9/19 22:11
 * Version 1.0
 **/
public class MethodComandHandlerException extends RuntimeException {


    public MethodComandHandlerException(String message) {
        super(message);
    }
}
