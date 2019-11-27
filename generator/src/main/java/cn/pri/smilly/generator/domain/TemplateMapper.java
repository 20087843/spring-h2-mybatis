package cn.pri.smilly.generator.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TemplateMapper {
    private String name;
    private String path;
    private Boolean isJava;
}
