package cn.pri.smilly.generator.service.impl;

import cn.pri.smilly.generator.service.GenerateService;
import cn.pri.smilly.generator.service.VelocityService;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.Writer;
import java.util.Map;

@Service
public class GenerateServiceImpl implements GenerateService {

    @Autowired
    private VelocityService velocityService;

    @Override
    public void generate(Writer writer, String templatePath, Map<String, String> params) {
        Assert.notEmpty(params, "velocity params can't be null or empty");
        VelocityEngine engine = velocityService.getVelocityEngine();
        VelocityContext context = velocityService.getVelocityContext();
        params.entrySet().stream().forEach(param -> context.put(param.getKey(), param.getValue()));
        Template template = engine.getTemplate(templatePath);
        template.merge(context, writer);
    }
}
