package cn.pri.smilly.generator.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class Table {
    private String name;
    private String comment;
    private String catalog;
    private String schema;
    private List<Column> columns;
}
