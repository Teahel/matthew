package com.matthew.interfaces;

/**
 * @Author: L.T.J
 * @project Lambda
 * @package com.matthew.interfaces
 * @CreateDate: 2019/9/11 10:25
 * @Version: 1.0
 */
public class DateTime {
    public static void main(String args[]){


        String datetime="190806 101800";


        String date=datetime.substring(0,6);
        System.out.println(date);
        String time=datetime.substring(7);
        System.out.println(time);
    }
}
