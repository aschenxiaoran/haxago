package com.xiaoran.infrastructure.callBack;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName FutureCallBack
 * Description TODO
 * Author xiaoran
 * Date 2019/9/17 10:30
 * Version 1.0
 **/
public class FutureCallBack<R> extends CompletableFuture<R> implements MessageCallBack<R> {

    //region override methods

    @Override
    public void onSuccess(R result) {

        super.complete(result);
    }

    @Override
    public void onFailure(Throwable e) {

        super.completeExceptionally(e);
    }

    public R getResult() {

        try {
            return super.get();
        } catch (InterruptedException e) {
            Thread.interrupted();
            return null;
        } catch (ExecutionException e) {
            throw (RuntimeException)e.getCause();
        }

    }

    //endregion
}
