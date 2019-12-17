package LeetCode.easy;

/**
 * @Author L.T.J
 * @Date 2019/12/11 15:57
 * @Version 1.0
 */
public class Palindrome {

    public static void main(String args[]){
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(-12321));
    }

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x==0){
            return true;
        }
        String value = String.valueOf(x);
        char a[] = value.toCharArray();
        StringBuffer end = new StringBuffer();
        for(int i=a.length-1;i>=0;i--){
            end.append(a[i]);
        }
        if(value.equals(end.toString())){
            return true;
        }
        return  false;
    }
}
