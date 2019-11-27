package cn.pri.smilly.generator.service;

import cn.pri.smilly.generator.domain.Table;

import java.util.List;

public interface DatabaseMetaService {

    List<Table> getTables();

    List<Table> getTables(List<String> tables);

}
