package cn.pri.smilly.generator.service.impl;

import cn.pri.smilly.generator.domain.TypeMapper;
import cn.pri.smilly.generator.exception.DataBaseException;
import cn.pri.smilly.generator.service.DataBaseTypeService;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DataBaseTypeServiceImpl implements DataBaseTypeService {
    private List<TypeMapper> types = new ArrayList<>(20);

    public DataBaseTypeServiceImpl(){
        types.add(TypeMapper.builder().typeCode(Types.ARRAY).typeName("ARRAY").javaType(Object.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.BIGINT).typeName("BIGINT").javaType(Long.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.BINARY).typeName("BINARY").javaType("byte[]").build());
        types.add(TypeMapper.builder().typeCode(Types.BIT).typeName("BIT").javaType(Boolean.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.BLOB).typeName("BLOB").javaType("byte[]").build());
        types.add(TypeMapper.builder().typeCode(Types.BOOLEAN).typeName("BOOLEAN").javaType(Boolean.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.CHAR).typeName("CHAR").javaType(String.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.CLOB).typeName("CLOB").javaType(String.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.DATALINK).typeName("DATALINK").javaType(Object.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.DATE).typeName("DATE").javaType(Date.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.DISTINCT).typeName("DISTINCT").javaType(Object.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.DOUBLE).typeName("DOUBLE").javaType(Double.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.FLOAT).typeName("FLOAT").javaType(Double.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.INTEGER).typeName("INTEGER").javaType(Integer.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.JAVA_OBJECT).typeName("JAVA_OBJECT").javaType(Object.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.LONGVARBINARY).typeName("LONGVARBINARY").javaType("byte[]").build());
        types.add(TypeMapper.builder().typeCode(Types.LONGVARCHAR).typeName("LONGVARCHAR").javaType(String.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.NULL).typeName("NULL").javaType(Object.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.OTHER).typeName("OTHER").javaType(Object.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.REAL).typeName("REAL").javaType(Float.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.REF).typeName("REF").javaType(Object.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.SMALLINT).typeName("SMALLINT").javaType(Short.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.STRUCT).typeName("STRUCT").javaType(Object.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.TIME).typeName("TIME").javaType(Date.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.TIMESTAMP).typeName("TIMESTAMP").javaType(Date.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.TINYINT).typeName("TINYINT").javaType(Byte.class.getName()).build());
        types.add(TypeMapper.builder().typeCode(Types.VARBINARY).typeName("VARBINARY").javaType("byte[]").build());
        types.add(TypeMapper.builder().typeCode(Types.VARCHAR).typeName("VARCHAR").javaType(String.class.getName()).build());
    }

    @Override
    public String getJavaType(Integer jdbcType) {
        return types.stream()
                .filter(type -> type.getTypeCode().equals(jdbcType))
                .map(type -> type.getJavaType())
                .findFirst()
                .orElseThrow(() -> new DataBaseException("JdbcType " + jdbcType + " not defined"));
    }

    @Override
    public String getTypeName(Integer jdbcType) {
        return types.stream()
                .filter(type -> type.getTypeCode().equals(jdbcType))
                .map(TypeMapper::getTypeName)
                .findFirst()
                .orElseThrow(() -> new DataBaseException("JdbcType " + jdbcType + " not defined"));
    }
}
