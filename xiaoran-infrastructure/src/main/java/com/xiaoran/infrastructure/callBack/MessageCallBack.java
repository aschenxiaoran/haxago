package com.xiaoran.infrastructure.callBack;

public interface MessageCallBack<R> {

    void onSuccess(R result);

    void onFailure(Throwable e);
}
