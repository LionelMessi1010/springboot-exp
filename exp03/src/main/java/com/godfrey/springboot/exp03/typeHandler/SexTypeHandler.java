package com.godfrey.springboot.exp03.typeHandler;

import com.godfrey.springboot.exp03.entity.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * description : 性别枚举处理类
 *
 * @author godfrey
 * @since 2020-04-18
 */
@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    /**
     * description : 根据结果集列名获取性别
     *
     * @param rs 1
     * @param columnName 2
     * @return : com.godfrey.springboot.exp03.enumeration.SexEnum
     * @author : godfrey
     * @since : 2020/4/19 12:17
     */
    @Override
    public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return SexEnum.getSexEnum(code);
    }

    /**
     * description : 根据结果集索引获取性别
     *
     * @param rs 1
     * @param index 2
     * @return : com.godfrey.springboot.exp03.enumeration.SexEnum
     * @author : godfrey
     * @since : 2020/4/19 12:19
     */
    @Override
    public SexEnum getNullableResult(ResultSet rs, int index) throws SQLException {
        int code = rs.getInt(index);
        return SexEnum.getSexEnum(code);
    }

    /**
     * description : 根据回调语句索引返回性别
     *
     * @param cs 1
     * @param index 2
     * @return : com.godfrey.springboot.exp03.enumeration.SexEnum
     * @author : godfrey
     * @since : 2020/4/19 12:23
     */
    @Override
    public SexEnum getNullableResult(CallableStatement cs, int index) throws SQLException {
        int code = cs.getInt(index);
        return SexEnum.getSexEnum(code);
    }

    /**
     * description : 根据预编译语句和字段返回性别
     *
     * @param ps 1
     * @param index 2
     * @param sex 3
     * @param jdbcType 4
     * @return : void
     * @author : godfrey
     * @since : 2020/4/19 12:27
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int index, SexEnum sex, JdbcType jdbcType) throws SQLException {
        ps.setInt(index, sex.getCode());
    }
}
