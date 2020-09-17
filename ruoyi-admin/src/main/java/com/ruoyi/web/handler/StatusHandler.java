package com.ruoyi.web.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.text.ParseException;
@MappedJdbcTypes({JdbcType.INTEGER})
@MappedTypes({String.class})
public class StatusHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i,switchToInt(parameter));
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return switchToString(rs.getInt(columnName));
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        return switchToString(rs.getInt(columnIndex));
    }

    @Override
    public String getNullableResult(@org.jetbrains.annotations.NotNull CallableStatement cs, int columnIndex)
            throws SQLException {
        return switchToString(cs.getInt(columnIndex));
    }

    public String switchToString(int i){
        switch (i){
            case 0:
                return "未付款";
            case 1:
                return "未完成出诊";
            case 2:
                return "已结束";
        }
        return null;
    }

    public int switchToInt(String s){
        switch (s){
            case "未付款":
                return 0;
            case "未完成出诊":
                return 1;
            case "已结束":
                return 2;
        }
        return -1;
    }

}
