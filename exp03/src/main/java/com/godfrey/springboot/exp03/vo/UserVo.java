package com.godfrey.springboot.exp03.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * description : 视图对象类
 *
 * @author godfrey
 * @since 2020-04-18
 */
@Setter
@Getter
public class UserVo {
    private Long id;
    private String userName;
    private int sexCode;
    private String sexName;
    private String note;
}
