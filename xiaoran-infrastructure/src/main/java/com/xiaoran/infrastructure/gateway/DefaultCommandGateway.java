package com.xiaoran.infrastructure.gateway;

import com.xiaoran.infrastructure.callBack.FutureCallBack;
import com.xiaoran.infrastructure.springs.CommandBus;

/**
 * @ClassName DefaultCommandGateway
 * Description 默认的命令网关
 * Author xiaoran
 * Date 2019/9/17 14:20
 * Version 1.0
 **/
public class DefaultCommandGateway implements CommandGatway {

    //region private variables

    private CommandBus commandBus;

    //endregion

    //region ctor

    public DefaultCommandGateway(CommandBus commandBus) {

        this.commandBus = commandBus;
    }

    //endregion

    //region override interface methods

    @Override
    public <Command, Result> Result send(Command command) {

        FutureCallBack<Result> callBack = new FutureCallBack<>();

        commandBus.dispatch(GenericCommandMessage.asCommandMessage(command), callBack);

        return callBack.getResult().getResult();
    }

    //endregion
}
