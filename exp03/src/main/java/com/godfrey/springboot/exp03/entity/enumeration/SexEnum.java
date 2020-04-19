package com.godfrey.springboot.exp03.entity.enumeration;

/**
 * description : 性别枚举类
 *
 * @author godfrey
 * @since 2020-04-18
 */
public enum SexEnum {

    MALE(0, "男"),
    FEMALE(1, "女");

    private int code;
    private String name;

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * description : 返回性别
     *
     * @param code 1
     * @return : com.godfrey.springboot.exp03.enumeration.SexEnum
     * @author : godfrey
     * @since : 2020/4/19 12:10
     */
    public static SexEnum getSexEnum(int code) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getCode() == code) {
                return sex;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
