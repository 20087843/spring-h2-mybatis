package cn.pri.smilly.generator.service.impl;

import cn.pri.smilly.generator.service.VelocityService;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.util.Map;
import java.util.Properties;

public class VelocityServiceImpl implements VelocityService {
    private Properties properties;
    private Map<String, String> params;

    public VelocityServiceImpl(Properties properties, Map<String, String> params) {
        this.properties = properties;
        this.params = params;
    }

    @Override
    public VelocityEngine getVelocityEngine() {
        return new VelocityEngine(properties);
    }

    @Override
    public VelocityContext getVelocityContext() {
        return new VelocityContext(params);
    }
}
