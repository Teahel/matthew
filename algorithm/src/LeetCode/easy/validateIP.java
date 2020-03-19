package LeetCode.easy;

import java.util.regex.Pattern;

/**
 * @Author L.T.J
 * @Date 2019/12/31 13:51
 * @Version 1.0
 */
public class validateIP {
    public static void main(String[] args) {
        String ipReg = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        Pattern ipPattern = Pattern.compile(ipReg);

        boolean flag = ipPattern.matcher("1.0.0.1").matches();
        System.out.println(flag);
        flag = ipPattern.matcher("aaaaaa").matches();
       /* String regex = "^([1-9]|[1-9]\\d{1,3}|[1-6][0-5][0-5][0-3][0-5])$";

        String port = "36.5";
        boolean flag = Pattern.matches(regex, port);

        System.out.println(flag);*/

        System.out.println();
    }
}
