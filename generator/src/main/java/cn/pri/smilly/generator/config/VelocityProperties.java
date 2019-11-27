package cn.pri.smilly.generator.config;

import cn.pri.smilly.generator.domain.TemplateMapper;
import cn.pri.smilly.generator.domain.TypeMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Setter
@Getter
@ConfigurationProperties("velocity")
public class VelocityProperties {
    private Properties config;
    private Map<String, String> params;

    private List<TemplateMapper> templates;
    private String basePackage;
    private String templatesPath;
    private List<String> tablePrefixs;
    private List<String> tables;
    private List<String> ignoredTables;
}
