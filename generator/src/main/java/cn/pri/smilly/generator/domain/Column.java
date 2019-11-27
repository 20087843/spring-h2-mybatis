package cn.pri.smilly.generator.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Column {
    private String name;
    private String comment;
    private Integer jdbcType;
    private Integer scale;
    private String javaType;
    private boolean isPrimary;
}
