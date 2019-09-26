package com.xiaoran.infrastructure.command;

public interface CommandMessage<Command> {

    String getCommandName();

    <R> R getResult();

}
