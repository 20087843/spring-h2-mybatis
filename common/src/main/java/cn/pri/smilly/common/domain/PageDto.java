package cn.pri.smilly.common.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageDto {
    private int pageNum;
    private int pageSize;
    private String orderBy;
}
