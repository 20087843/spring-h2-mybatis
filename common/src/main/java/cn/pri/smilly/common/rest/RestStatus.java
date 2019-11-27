package cn.pri.smilly.common.rest;

import lombok.Getter;

@Getter
public enum RestStatus {
    SUCCESS(200, "success"),
    VRFFAIL(300, "verificate fail:"),
    SVRERR(500, "server error:");

    private int code;
    private String msg;

    RestStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
