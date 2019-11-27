package cn.pri.smilly.generator.service;

import java.util.zip.DataFormatException;

public interface DataBaseTypeService {

    String getJavaType(Integer jdbcType) throws Throwable;

    String getTypeName(Integer jdbcType) throws DataFormatException;

}
