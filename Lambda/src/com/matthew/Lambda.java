package com.matthew;

/**
 * @Author: L.T.J
 * @project Lambda
 * @package com.matthew
 * @CreateDate: 2019/9/6 11:57
 * @Version: 1.0
 */
public class Lambda {

    public static void main(String args[]){
        Lambda lambda =  new Lambda();

        System.out.println(lambda.reserverString("2019-10-20"));

    }

    public String reserverString(String s){
        String b = s.replaceAll("-","").substring(2,8);
        return b;
    }
}
