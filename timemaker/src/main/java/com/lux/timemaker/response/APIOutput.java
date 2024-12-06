
package com.lux.timemaker.response;

import java.io.Serializable;


public class APIOutput<T> implements Serializable {
    private Boolean status;
    private T data;
    private String msg;

    public APIOutput() {
        this.data = (T) new EmptyBean();
        this.msg = "";
    }

    public APIOutput(Boolean status, T data) {
        this.status = status;
        this.data = data;
        this.msg = "";
    }

    public APIOutput(Boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public APIOutput(Boolean status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "APIOutput{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
