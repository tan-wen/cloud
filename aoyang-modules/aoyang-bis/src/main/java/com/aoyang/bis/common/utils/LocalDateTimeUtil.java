package com.aoyang.bis.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * @ClassName : LocalDateTimeUtils
 * @Description :
 * @Author : GC
 * @Date: 2021-05-05 10:02
 */
public class LocalDateTimeUtil {

    /**
     * 根据传入的时间获取当天的开始结束时间,start开始时间,end结束时间
     */
    public static LocalDateTime getDateInfo(LocalDateTime date, String sign) throws ParseException {
        if("start".equals(sign)){

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date date1 = localDate2DateTime(date);
            String format = simpleDateFormat.format(date1);
            String day = format.substring(0, 10);
            String s = day + " 00:00:00";
            Date parse = simpleDateFormat.parse(s);

            return date2LocalDateTime(parse);
        }
        if("end".equals(sign)){

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = localDate2DateTime(date);
            String format = simpleDateFormat.format(date1);
            String day = format.substring(0, 10);
            String s = day + " 23:59:59";
            Date parse = simpleDateFormat.parse(s);
            return date2LocalDateTime(parse);
        }
        return null;
    }

    public static Date localDate2DateTime(LocalDateTime localDateTime) {
        //java中使用该形式的zoneId会自动计算夏令时
        ZoneId zoneId = ZoneId.systemDefault();

        //和offsetDateTime的差异是后者包括涵盖夏令时调整的规则
        ZonedDateTime zdt = localDateTime.atZone(zoneId);

        return Date.from(zdt.toInstant());
    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        //转为UTC时间
        Instant instant = date.toInstant();
        //获取本机的ZoneId
        ZoneId zoneId = ZoneId.systemDefault();
        //UTC时间计算夏令时然后转为LocalDateTime
        return instant.atZone(zoneId).toLocalDateTime();
    }
}
