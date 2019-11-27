package cn.pri.smilly.generator.service;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.util.Map;
import java.util.Properties;

public interface VelocityService {
    VelocityEngine getVelocityEngine();

    VelocityContext getVelocityContext();
}
