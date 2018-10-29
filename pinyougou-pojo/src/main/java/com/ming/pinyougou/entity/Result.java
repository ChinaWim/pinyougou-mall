package com.ming.pinyougou.entity;

import java.io.Serializable;

/**
 * @author m969130721@163.com
 * @date 18-10-28 下午3:07
 */
public class Result implements Serializable {
    private boolean success;

    private String message;
    public Result(boolean success,String message){
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
