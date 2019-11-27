package cn.pri.smilly.generator.service;

import java.io.Writer;
import java.util.Map;

public interface GenerateService {

    void generate(Writer writer, String templatePath, Map<String, String> params);

}
