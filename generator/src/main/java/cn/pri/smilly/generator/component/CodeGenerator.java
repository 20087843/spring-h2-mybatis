package cn.pri.smilly.generator.component;

import cn.pri.smilly.generator.domain.SystemContext;
import cn.pri.smilly.generator.domain.TemplateMapper;
import cn.pri.smilly.generator.service.DatabaseMetaService;
import cn.pri.smilly.generator.service.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CodeGenerator {
    @Autowired
    private GenerateService generateService;
    @Autowired
    private DatabaseMetaService databaseMetaService;
    @Autowired
    private SystemContext context;

    public void execute() {
        List<TemplateMapper> templates = context.getTemplates();
        for(TemplateMapper template : templates){
            // TODO
        }
    }
}
