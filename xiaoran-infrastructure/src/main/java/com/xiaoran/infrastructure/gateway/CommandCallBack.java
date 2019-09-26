package com.xiaoran.infrastructure.gateway;

/**
 * 一个command 的handler执行完成后的回调
* */
public interface CommandCallBack<TCommand, TResult> {

    void onResult();

}
