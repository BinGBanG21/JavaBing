package com.javabing.train.member.enums;/*
 * ClassName: PassengerTypeEnum
 * Package: com.javabing.train.member.enums
 * Description:
 * @Author WangBing
 * @Create 2024/9/10/星期二 19:51
 * @Version 1.0
 **/

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

public enum PassengerTypeEnum {

    ADULT("1", "成人"),
    CHILD("2", "儿童"),
    STUDENT("3", "学生");

    private String code;

    private String desc;

    PassengerTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static List<HashMap<String,String>> getEnumList() {
        List<HashMap<String, String>> list = new ArrayList<>();
        for (PassengerTypeEnum anEnum : EnumSet.allOf(PassengerTypeEnum.class)) {
            HashMap<String, String> map = new HashMap<>();
            map.put("code",anEnum.code);
            map.put("desc",anEnum.desc);
            list.add(map);
        }
        return list;
    }
}

