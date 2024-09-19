package com.javabing.train.business.mapper.cust;/*
 * ClassName: DailyTrainTicketMapperCust
 * Package: com.javabing.train.business.mapper.cust
 * Description:
 * @Author WangBing
 * @Create 2024/9/19/星期四 14:23
 * @Version 1.0
 **/

import java.util.Date;

public interface DailyTrainTicketMapperCust {

    void updateCountBySell(Date date
            , String trainCode
            , String seatTypeCode
            , Integer minStartIndex
            , Integer maxStartIndex
            , Integer minEndIndex
            , Integer maxEndIndex);
}
