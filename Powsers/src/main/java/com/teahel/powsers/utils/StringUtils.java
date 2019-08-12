package com.teahel.powsers.utils;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/4/8
 * Time: 22:26
 * Description: 判断字符串是否为空
 */
public class StringUtils {
    //空字符串
    public boolean isEmpty(String string){
        if(string.equals(null)){
            return  true;
        }
        if(string.equals("")){
            return true;
        }
        return false;
    }
   //非空
    public boolean isNotEmpty(String string){
        if(!isEmpty(string)){
            return  true;
        }
        return false;
    }
}
