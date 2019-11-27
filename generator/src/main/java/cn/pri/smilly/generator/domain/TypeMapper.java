package cn.pri.smilly.generator.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class TypeMapper {
    private Integer typeCode;
    private String typeName;
    private String javaType;
}
