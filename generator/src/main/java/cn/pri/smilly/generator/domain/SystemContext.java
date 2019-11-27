package cn.pri.smilly.generator.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class SystemContext {
    private String basePackage;
    private String templatesPath;
    private List<String> tablePrefixs;
    private List<TemplateMapper> templates;
    private List<TypeMapper> types;
    private List<String> tables;
    private List<String> ignoredTables;
}
