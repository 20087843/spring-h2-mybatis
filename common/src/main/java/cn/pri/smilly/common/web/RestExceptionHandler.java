package cn.pri.smilly.common.web;

import cn.pri.smilly.common.rest.RestResult;
import cn.pri.smilly.common.rest.RestStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RestResult<Exception> handleException(Exception e) {
        return RestResult.build(RestStatus.SVRERR, e.getMessage(), e);
    }

}
