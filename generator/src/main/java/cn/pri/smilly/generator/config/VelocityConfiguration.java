package cn.pri.smilly.generator.config;

import cn.pri.smilly.generator.domain.SystemContext;
import cn.pri.smilly.generator.domain.TemplateMapper;
import cn.pri.smilly.generator.domain.TypeMapper;
import cn.pri.smilly.generator.service.VelocityService;
import cn.pri.smilly.generator.service.impl.VelocityServiceImpl;
import lombok.Getter;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@ConditionalOnProperty("velocity")
@EnableConfigurationProperties(VelocityProperties.class)
public class VelocityConfiguration {

    @Getter
    @Autowired
    private VelocityProperties velocityProperties;

    @Bean
    public VelocityService velocityService() {
        return new VelocityServiceImpl(properties(), params());
    }

    @Bean
    public SystemContext systemContext() {
        return SystemContext.builder()
                .basePackage(velocityProperties.getBasePackage())
                .templatesPath(velocityProperties.getTemplatesPath())
                .tablePrefixs(velocityProperties.getTablePrefixs())
                .tables(velocityProperties.getTables())
                .ignoredTables(velocityProperties.getIgnoredTables())
                .templates(templates())
                .build();
    }

    private Properties properties() {
        Properties properties = Optional.ofNullable(velocityProperties.getConfig()).orElse(new Properties());
        properties.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        properties.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        return properties;
    }

    private Map<String, String> params() {
        Map<String, String> params = Optional.ofNullable(velocityProperties.getParams()).orElse(new HashMap<>());
        return params;
    }

    private List<TemplateMapper> templates() {
        List<TemplateMapper> templates = Optional.ofNullable(velocityProperties.getTemplates()).orElse(defaultTemplates());
        return templates;
    }

    private List<TemplateMapper> defaultTemplates() {
        List<TemplateMapper> templates = new ArrayList<>(6);
        templates.add(TemplateMapper.builder().name("controller.java.vm").path("src/main/java/cn/pri/smilly/project/controller").isJava(true).build());
        templates.add(TemplateMapper.builder().name("domain.java.vm").path("src/main/java/cn/pri/smilly/project/domain").isJava(true).build());
        templates.add(TemplateMapper.builder().name("mapper.java.vm").path("src/main/java/cn/pri/smilly/project/mapper").isJava(true).build());
        templates.add(TemplateMapper.builder().name("mapper.xml.vm").path("src/main/resources/mapper").isJava(false).build());
        templates.add(TemplateMapper.builder().name("service.java.vm").path("src/main/java/cn/pri/smilly/project/service").isJava(true).build());
        templates.add(TemplateMapper.builder().name("serviceImpl.java.vm").path("src/main/java/cn/pri/smilly/project/service/impl").isJava(true).build());
        return templates;
    }

}
