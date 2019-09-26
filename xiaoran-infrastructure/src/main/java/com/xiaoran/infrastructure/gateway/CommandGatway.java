package com.xiaoran.infrastructure.gateway;


/**
 *分配命令的网关，允许调用者发送命令并等待结果
 * @author xiaoran
 * @see DefaultCommandGateway
 *
 * */
public interface CommandGatway {

    <Command,Result> Result send(Command command);

}
