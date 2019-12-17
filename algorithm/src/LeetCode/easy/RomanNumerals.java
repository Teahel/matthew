package LeetCode.easy;

/**
 *罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * @Author L.T.J
 * @Date 2019/12/16 10:40
 * @Version 1.0
 */
public class RomanNumerals {
    public static void main(String args[]){
        /*
        for(int i=0;i<10;i++){
            System.out.println('数字：'+i);
            if(i==4){
                i = i+2;
                System.out.println('数字：'+i);
            }
            "LVIII"
        }*/
        RomanNumerals romanNumerals = new RomanNumerals();
        System.out.println(romanNumerals.romanToInt("LVIII"));

    }

    public int romanToInt (String s) {
        int a = 0;
        char b[] = s.toCharArray();
       for(int i = 0; i<b.length;i++){
           if('M'==b[i]){
               a =1000+a;
           } else if('D'==b[i]){
               a = 500+a;
           } else if('C'==b[i]){
               if(i+1<b.length){
                   if('M'==b[i+1]){
                       i++;
                       a = 900+a;
                   } else if('D'==b[i+1]){
                       i++;
                       a = 400+a;
                   } else {
                       a = 100+a;
                   }
               } else if(i+1==b.length){
                   a = 100+a;
               }
           } else if('L'==b[i]){
               a = 50+a;
           } else if('X'==b[i]){
               if(i+1<b.length){
                   if('L'==b[i+1]){
                       i++;
                       a = 40+a;
                   } else if('C'==b[i+1]){
                       i++;
                       a = 90+a;
                   } else {
                       a = 10+a;
                   }
               } else if(i+1==b.length){
                   a = 10+a;
               }
           } else if('V'==b[i]){
               a = 5+a;
           } else if('I'==b[i]){
               if(i+1<b.length){
                   if('V'==b[i+1]){
                       i++;
                       a = 4+a;
                   } else if('X'==b[i+1]){
                       i++;
                       a = 9+a;
                   } else {
                       a = 1+a;
                   }
               }else if(i+1==b.length){
                   a = 1+a;
               }
           }
       }
       return a;
    }
}
