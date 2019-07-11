package com.jiajia.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * jdk8中时间的运用
 */
public class TestTime {
    /**
     * localDate() localTime() localDateTime()
     *
     */
    @Test
    public void test(){
        // 当然 日期  当然时间  当前日期+时间
        LocalDate localDate = LocalDate.now() ;
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println("当前日期:" + localDate + "\n当前时间：" + localTime + "\n当前日期加时间 ： " + localDateTime);
        // .of() 指定特定的 时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2020,10,10,10,10,10);
        System.out.println("\n指定的时间是 : " + localDateTime1);
        //获取相关属性
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println("\n获取到的时间中的属性：" + "\n年" + localDateTime2.getYear() +"\n分钟" + localDateTime2.getMinute() + "\n 当月的第几天" + localDateTime2.getDayOfMonth());
        // 自定义时间格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println("格式化时间 ： " + format);
        // 解析字符串
        TemporalAccessor parse = dateTimeFormatter.parse(format);
        System.out.println("转化后的时间 : "+ parse);



    }
}
