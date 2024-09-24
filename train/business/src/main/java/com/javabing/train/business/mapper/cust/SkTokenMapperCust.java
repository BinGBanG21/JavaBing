package com.javabing.train.business.mapper.cust;/*
 * ClassName: SkTokenMapperCust
 * Package: com.javabing.train.business.mapper.cust
 * Description:
 * @Author WangBing
 * @Create 2024/9/24/星期二 16:10
 * @Version 1.0
 **/

import java.util.Date;

public interface SkTokenMapperCust {

    int decrease(Date date, String trainCode);
}
