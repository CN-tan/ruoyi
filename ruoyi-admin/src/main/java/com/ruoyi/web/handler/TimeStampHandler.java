package com.ruoyi.web.handler;

import com.ruoyi.common.utils.sql.SqlUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.text.ParseException;
@MappedJdbcTypes({JdbcType.INTEGER})
@MappedTypes({String.class})
public class TimeStampHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
       try {
            ps.setInt(i, SqlUtil.dateToStamp(parameter, "yyyy-MM-dd HH:mm:ss"));
       }catch (ParseException E){

       }
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
            return SqlUtil.stampToDate(rs.getInt(columnName),"yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
            return SqlUtil.stampToDate(rs.getInt(columnIndex),"yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public String getNullableResult(@org.jetbrains.annotations.NotNull CallableStatement cs, int columnIndex)
            throws SQLException {
            return SqlUtil.stampToDate(cs.getInt(columnIndex),"yyyy-MM-dd HH:mm:ss");
    }

}
