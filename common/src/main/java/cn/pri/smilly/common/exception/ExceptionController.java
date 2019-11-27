package cn.pri.smilly.common.exception;

import cn.pri.smilly.common.rest.RestResult;
import cn.pri.smilly.common.rest.RestStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public RestResult<Exception> handleException(Exception e) {
        return RestResult.build(RestStatus.SVRERR, e.getMessage(), e);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public RestResult<Exception> handleIllegalArgumentException(IllegalArgumentException e) {
        return RestResult.build(RestStatus.VRFFAIL, e.getMessage(), e);
    }

}
