package com.matthew.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class SubtractionOfTime {
    public static void main(String args[]) throws ParseException {
        hourTime();
        getMonthDiff();
        dayTime();
        testHour();
    }

    /**
     * 小时差
     */
    public static void hourTime(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Date d1 = df.parse("2019-12-04 13:31:40");
            Date d2 = df.parse(df.format(new Date()));
            System.out.println("天数："+df.format(new Date()));
            long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            long days = diff / (1000 * 60 * 60 * 24);

            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
            days +=1;
            System.out.println("详细天数 "+days+"天"+hours+"小时");

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 天数差
     */
    public static void dayTime() throws ParseException {
        String d1 = "2012-01-12";
        String d2 = "2010-03-11";
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(d1));
        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        c.setTime(sdf.parse(d2));
        int year2 = c.get(Calendar.YEAR);
        int month2 = c.get(Calendar.MONTH);

        int result;
        if(year1 == year2) {
            result = month1 - month2;
        } else {
            result = 12*(year1 - year2) + month1 - month2;
        }
       System.out.println(result);
    }

    /**
     * 获取两个日期相差的月数
     */
    public static void getMonthDiff() throws ParseException {
        String d1 = "2019-12-04 13:31:40";
        //String d2 = "2010-02-11";
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(d1));
        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH);

        c.setTime(sdf.parse(sdf.format(new Date())));
        int year2 = c.get(Calendar.YEAR);
        int month2 = c.get(Calendar.MONTH);

        int result;
        if(year1 == year2) {
            result = month1 - month2;
        } else {
            result = 12*(year1 - year2) + month1 - month2;
        }
        System.out.println("月份： "+result);

    }

    public static void testHour(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime end = LocalDateTime.parse("2019-12-05 09:07:05", df);
        Duration duration = Duration.between(end ,  now);

        System.out.println(duration.toHours());
        System.out.println(duration.toDays());

    }

}
