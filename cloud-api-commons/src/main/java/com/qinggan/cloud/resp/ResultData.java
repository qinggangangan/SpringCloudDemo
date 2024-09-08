package com.qinggan.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description:
 * Author: 1401687501x's
 * Date: 2024/8/1 17:46
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {

    private String code;
    private String message;
    private T data;
    private long timestamp;

    public ResultData(){
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode())
                .setMessage(ReturnCodeEnum.RC200.getMessage())
                .setData(data);
        return resultData;
    }

    public static <T> ResultData<T> fail(String code, String message){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code)
                .setMessage(message)
                .setData(null);
        return resultData;
    }
}

