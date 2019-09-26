package com.xiaoran.infrastructure.gateway;

import com.xiaoran.infrastructure.command.CommandMessage;

/**
 * @ClassName Description TODO
 * Author xiaoran
 * Date 2019/9/26 15:20
 * Version 1.0
 **/
public class GenericCommandMessage<TResult> implements CommandMessage<TResult>{

    //region private variables

    private final String commandName;

    private TResult result;

    //endregion

    //region ctor

    public GenericCommandMessage(TResult TResult) {
        this.result= TResult;
        this.commandName = TResult.getClass().getName();
    }

    //endregion

    //region overide methods

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public TResult getResult() {
        return this.result;
    }

    //endregion

    //region public static methods

    public static <C> CommandMessage<C> asCommandMessage(Object command) {
        return new GenericCommandMessage(command);
    }

    //endregion
}
