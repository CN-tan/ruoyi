package com.ruoyi.common.utils.sql;

import com.ruoyi.common.exception.base.BaseException;
import com.ruoyi.common.utils.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sql操作工具类
 * 
 * @author ruoyi
 */
public class SqlUtil
{
    /**
     * 仅支持字母、数字、下划线、空格、逗号、小数点（支持多个字段排序）
     */
    public static String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,\\.]+";

    /**
     * 检查字符，防止注入绕过
     */
    public static String escapeOrderBySql(String value)
    {
        if (StringUtils.isNotEmpty(value) && !isValidOrderBySql(value))
        {
            throw new BaseException("参数不符合规范，不能进行查询");
        }
        return value;
    }

    /**
     * 验证 order by 语法是否符合规范
     */
    public static boolean isValidOrderBySql(String value)
    {
        return value.matches(SQL_PATTERN);
    }

    public  static int dateToStamp(String date,String pattern) throws ParseException {
        final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        final Date datetime = sdf.parse(date);
        return Integer.parseInt(String.valueOf(datetime.getTime()/1000));
    }

    public static String stampToDate(int time,String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date(time * 1000L));
    }
}
