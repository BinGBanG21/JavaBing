package com.javabing.train.common.util;/*
 * ClassName: SnowUtil
 * Package: com.javabing.train.common.util
 * Description:
 * @Author WangBing
 * @Create 2024/9/8/星期日 13:32
 * @Version 1.0
 **/

import cn.hutool.core.util.IdUtil;

/**
 * 封装hutool雪花算法
 */
public class SnowUtil {

    private static long dataCenterId = 1;  //数据中心
    private static long workerId = 1;     //机器标识

    public static long getSnowflakeNextId() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextId();
    }

    public static String getSnowflakeNextIdStr() {
        return IdUtil.getSnowflake(workerId, dataCenterId).nextIdStr();
    }
}