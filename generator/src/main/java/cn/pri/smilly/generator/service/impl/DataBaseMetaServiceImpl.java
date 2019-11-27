package cn.pri.smilly.generator.service.impl;

import cn.pri.smilly.generator.domain.Column;
import cn.pri.smilly.generator.domain.SystemContext;
import cn.pri.smilly.generator.domain.Table;
import cn.pri.smilly.generator.exception.DataBaseException;
import cn.pri.smilly.generator.service.DatabaseMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataBaseMetaServiceImpl implements DatabaseMetaService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private SystemContext context;

    @Override
    public List<Table> getTables() {
        List<Table> tables = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             ResultSet rs = connection.getMetaData().getTables(null, null, null, null)) {
            while (rs.next()) {
                Table table = resolveTable(rs);
                if (null == table) {
                    continue;
                }

                tables.add(table);
            }

            return tables;
        } catch (SQLException e) {
            throw new DataBaseException(e);
        }
    }

    @Override
    public List<Table> getTables(List<String> tables) {
        List<Table> tbs = new ArrayList<>();
        for (String table : tables) {
            try (Connection connection = dataSource.getConnection();
                 ResultSet rs = connection.getMetaData().getTables(null, null, table, null)) {
                if (rs.next()) {
                    Table tb = resolveTable(rs);
                    tbs.add(tb);
                }
            } catch (SQLException e) {
                throw new DataBaseException(e);
            }
        }
        return tbs;
    }

    private Table resolveTable(ResultSet rs) throws SQLException {
        Table table = Table.builder()
                .name(rs.getString("TABLE_NAME"))
                .catalog(rs.getString("TABLE_CAT"))
                .schema(rs.getString("TABLE_SCHEM"))
                .build();

        if (!CollectionUtils.isEmpty(context.getIgnoredTables()) && context.getIgnoredTables().contains(table.getName())) {
            return null;
        }

        List<Column> columns = resolveColumns(table);
        table.setColumns(columns);

        return table;
    }

    private List<Column> resolveColumns(Table table) throws SQLException {
        List<Column> columns = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             ResultSet rs = connection.getMetaData().getColumns(table.getCatalog(), table.getSchema(), table.getName(), null)) {
            while (rs.next()) {
                Column column = Column.builder()
                        .name(rs.getString("COLUMN_NAME"))
                        .javaType(rs.getString("DATA_TYPE"))
                        .jdbcType(rs.getInt("DATA_TYPE"))
                        .scale(rs.getInt("DECIMAL_DIGITS"))
                        .build();
                columns.add(column);
            }
        }

        Column primary = resolvePrimary(table);
        columns.add(primary);

        return columns;
    }

    private Column resolvePrimary(Table table) throws SQLException {
        Column column = null;
        try (Connection connection = dataSource.getConnection();
             ResultSet rs = connection.getMetaData().getPrimaryKeys(table.getCatalog(), table.getSchema(), table.getName())) {
            if (rs.next()) {
                column = Column.builder()
                        .name(rs.getString("COLUMN_NAME"))
                        .javaType(rs.getString("DATA_TYPE"))
                        .isPrimary(true)
                        .build();
            }
        }

        return column;
    }

}
