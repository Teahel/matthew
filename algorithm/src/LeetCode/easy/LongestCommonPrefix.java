package LeetCode.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author L.T.J
 * @Date 2019/12/17 8:37
 * @Version 1.0
 */
public class LongestCommonPrefix {

    public static void main(String args[]){
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String str[] = {"c","c"}; //["a","a","b"]
        //String str[] = {"a"};
        System.out.println( longestCommonPrefix.longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs) {
        int num = 0;
        String prefix = "";
        boolean flag = false;
        int  oneNum = 0;
        String temp = "";
        String tempOne= "";
        String testTemp[] = new String[strs.length];
        for(int l=0;l<strs.length;l++){
            if(strs[l].length()==1){
                testTemp[oneNum]=strs[l];
                oneNum++;
                temp=strs[l];

            }
            if(strs[l].length()==0){
                return "";
            }
        }
        if(oneNum==1){
            return  temp;
        } else if(oneNum>1) {
             boolean fs = false;
             for(int o=0;o<oneNum-1;o++){
                 if(testTemp[o]!=testTemp[o+1]){
                     fs = true;
                 }
             }
             if(fs){
                 return "";
             } else {
                 return testTemp[0];
             }
        }
        for(int i=0;i<strs.length-1;i++){
           for(int j=i+1;j<strs.length;j++){
               char a[] =strs[i].toCharArray();
               char b[] =strs[j].toCharArray();
               if(a.length>b.length){
                   for(int s =0 ;s<b.length;s++){
                       if(a[s]==b[s]){
                           flag =true;
                           if(num>0){
                               if(num>s+1){
                                   num = s+1;
                                   prefix = strs[i].substring(0,num);
                               }
                           } else {
                               num = s+1;
                               prefix = strs[i].substring(0,num);
                           }
                       } else {
                           flag =false;
                       }
                       if(!flag){
                         break;
                       }
                   }
               } else {
                   for(int s =0 ;s<a.length;s++){
                       if(a[s]==b[s]){
                           flag =true;
                           if(num>0){
                               if(num<s+1){
                                   num = s+1;
                                   prefix = strs[i].substring(0,num);
                               }
                           } else {
                               num = s+1;
                               prefix = strs[i].substring(0,num);
                           }
                       } else {
                           flag =false;
                       }
                       if(!flag){
                           break;
                       }
                   }
               }

           }
        }
        return prefix;
    }
}
