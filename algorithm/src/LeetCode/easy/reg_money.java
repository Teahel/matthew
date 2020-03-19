package LeetCode.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author L.T.J
 * @Date 2020/3/18 10:26
 * @Version 1.0
 */
public class reg_money{

    public static void main(String args[]){
        String reg_money = "\\d+(\\.\\d{1,2})?";// 金额正则,可以没有小数，小数最多不超过两位
        Pattern pattern = Pattern.compile(reg_money);
        Matcher matcher = pattern.matcher("10005566.26");
        boolean ismatch = matcher.matches();
        System.out.println(ismatch);


        }
}
