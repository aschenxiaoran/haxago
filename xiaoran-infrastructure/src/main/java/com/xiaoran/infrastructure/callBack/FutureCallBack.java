package com.xiaoran.infrastructure.callBack;

/**
 * @ClassName FutureCallBack
 * Description TODO
 * Author xiaoran
 * Date 2019/9/17 10:30
 * Version 1.0
 **/
public class FutureCallBack implements MessageCallBack {

    private MessageCallBack messageCallBack;

    public FutureCallBack(MessageCallBack messageCallBack) {
        this.messageCallBack = messageCallBack;
    }

    @Override
    public void onSuccess() {
        this.messageCallBack.onSuccess();

    }
}
