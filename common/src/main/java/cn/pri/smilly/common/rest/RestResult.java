package cn.pri.smilly.common.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestResult<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> RestResult<T> build(RestStatus status, String msg, T data) {
        return new RestResult(status.getCode(), msg, data);
    }

    public static <T> RestResult<T> success(T data) {
        return build(RestStatus.SUCCESS, RestStatus.SUCCESS.getMsg(), data);
    }

    public static RestResult fail(RestStatus status, String msg) {
        return build(status, status.getMsg() + msg, null);
    }

}
