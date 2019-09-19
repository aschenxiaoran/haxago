package com.xiaoran.infrastructure.exception;

/**
 * 默认CommandHandler注解的方法只能有一个Command参数
 * @ClassName Description 命令参数数量异常
 * Author xiaoran
 * Date 2019/9/19 22:05
 * Version 1.0
 **/
public class InvalidCommandCountException extends RuntimeException {


    public InvalidCommandCountException(String errorMessage) {
        super(errorMessage);
    }
}
