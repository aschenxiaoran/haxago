package com.xiaoran.infrastructure.callBack;

import com.xiaoran.infrastructure.command.CommandMessage;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FutureCallBackTest {

    @Test
    public void onSuccess() {

        FutureCallBack<String> callBack=new FutureCallBack();

        String result="test future call back on success";
        callBack.onSuccess(result);

        CommandMessage<String> futureResult= callBack.getResult();

        Assert.assertTrue(futureResult.getResult().equals(result));
    }

    @Test
    public void onFailure() {

        FutureCallBack<String> callBack=new FutureCallBack();
        final String errorMessage="测试异常抛出";
        try {
            throw new RuntimeException(errorMessage);
        }catch (Exception ex){
            callBack.onFailure(ex);
        }
        CommandMessage<String> futureResult=callBack.getResult();
        Assert.assertTrue(errorMessage.equals(futureResult.getResult()));

    }

    @Test
    public void getResult() {

    }
}
