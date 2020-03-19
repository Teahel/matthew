package LeetCode.easy;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author L.T.J
 * @Date 2020/3/10 15:22
 * @Version 1.0
 */
public class Main {
    public static void main(String []args)
    {
      /*  GregorianCalendar gre=new GregorianCalendar();
        Date date=new Date(2020-1900,03-1,10); //年要减去1900，月份是0-11
//            System.out.println(date);

        gre.setTime(date);
        int weekday=gre.get(Calendar.DAY_OF_WEEK)-1; //0是星期天
        String []s={"星期天","星期一","星期二","星期三","星期四","星期五","星期六",};
        System.out.println(s[weekday]);
*/
        String ss = "50.36";
        int test = (int)(Double.parseDouble(ss)*100);
        System.out.println(test);


      System.out.println(timeStrToDateStr("200310161728"));

    }

    /**
     * @param timeStr 转换前的字符串
     * @return 标准时间格式字符串
     */
    public  static String timeStrToDateStr(String timeStr) {
        String timeBuff = "20000000000000";
        if (null == timeStr || timeBuff.equals(timeStr)) {
            return null;
        }

        String dateStr = null;
        //输入格式
        SimpleDateFormat sdf_input = new SimpleDateFormat("yyMMddHHmmss");
        //转化成为的目标格式
        SimpleDateFormat sdf_target = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

        try {
            dateStr = sdf_target.format(sdf_input.parse(timeStr));

        } catch (Exception e) {
        }

        return dateStr;
    }
}
