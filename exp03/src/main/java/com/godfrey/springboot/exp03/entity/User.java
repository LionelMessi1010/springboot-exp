package com.godfrey.springboot.exp03.entity;

import com.godfrey.springboot.exp03.entity.enumeration.SexEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * description : 实体类
 *
 * @author godfrey
 * @since 2020-04-18
 */
@Setter
@Getter
@Alias("user")
public class User {
    private Long id;
    private String userName;
    private SexEnum sex = null;
    private String note;
}