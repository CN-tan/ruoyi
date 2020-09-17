package com.ruoyi.web.handler;

import com.ruoyi.framework.web.domain.server.Sys;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import java.sql.*;
import java.text.ParseException;
@MappedJdbcTypes({JdbcType.VARCHAR})
@MappedTypes({String.class})
public class LevelHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setString(i,switchToInt(parameter));
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return switchToString(rs.getString(columnName));
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        return switchToString(rs.getString(columnIndex));
    }

    @Override
    public String getNullableResult(@org.jetbrains.annotations.NotNull CallableStatement cs, int columnIndex)
            throws SQLException {
        return switchToString(cs.getString(columnIndex));
    }

    public String switchToString(String i){
        switch (i){
            case "0":
                return "一级丙等";
            case "1":
                return "一级乙等";
            case "2":
                return "一级甲等";
            case "3":
                return "二级丙等";
            case "4":
                return "二级乙等";
            case "5":
                return "二级甲等";
            case "6":
                return "三级丙等";
            case "7":
                return "三级乙等";
            case "8":
                return "三级甲等";
            case "9":
                return "三级特等";
            default:
        }
        return null;
    }

    public String switchToInt(String s){
        switch (s){
            case "一级丙等":
                return "0";
            case "一级乙等":
                return "1";
            case "一级甲等":
                return "2";
            case "二级丙等":
                return "3";
            case "二级乙等":
                return "4";
            case "二级甲等":
                return "5";
            case "三级丙等":
                return "6";
            case "三级乙等":
                return "7";
            case "三级甲等":
                return "8";
            case "三级特等":
                return "9";
            default:
        }
        return null;
    }

}
