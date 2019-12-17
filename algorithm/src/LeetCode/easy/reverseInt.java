package LeetCode.easy;


import java.math.BigDecimal;

/**
 * @Author L.T.J
 * @Date 2019/12/11 11:16
 * @Version 1.0
 */
public class reverseInt {
    public static void main(String args[]){
     /*
        题目：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
        System.out.println(215%10);
        System.out.println(215/10);
        Line 21: java.lang.NumberFormatException: For input string: "9646324351"
     */
       // System.out.println(reverse(-123456789));
        System.out.println(reverse(1564842369));

    }

    public static int reverse(int x){
        String  result = "";
        int temp = x;
        if(temp>0){
            while (temp!=0){
                result += temp%10;
                temp /=10;
            }
        } else if(temp<0){
            temp=Math.abs(x);
            while (temp!=0){
                result += temp%10;
                temp /=10;
            }
            try{
                return -Integer.parseInt(result);
            }catch (NumberFormatException e){
                return 0;
            }

        } else {
            return x;
        }
        try{
            return Integer.parseInt(result);
        }catch (NumberFormatException e){
            return 0;
        }
    }
}

