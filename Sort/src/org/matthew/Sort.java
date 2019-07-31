package org.matthew;

/**
 * Created by Theahel
 * User: Matthew
 * Date: 2019/7/23
 * Time: 23:43
 * Description: 从小到大 ，java的五个排序， 冒泡 选择 插入 快速 归并排序
 */
public class Sort {
   public static void main(String args[]){
       Sort sort=new Sort();
   }
   //冒泡排序
       int arr[]={1,-10,-5,2,9,4,0,0,3};
       for(int i=0;i<arr.length-1;i++){
           for(int j=0;j<arr.length-1-i;j++){
               if(arr[j]>arr[j+1]){
                   int temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
               }
           }
       }
       for(int s=0;s<arr.length;s++){
           System.out.println(arr[s]);
       }
   }

   //选择排序
       int arr[]={1,-10,-5,2,9,4,0,0,3};
       for(int i=0;i<arr.length-1;i++){
           for(int j=i+1;j<arr.length;j++){
               if(arr[i]>arr[j]){
                   int temp=arr[i];
                   arr[i]=arr[j];
                   arr[j]=temp;
               }
           }
       }
       for(int s=0;s<arr.length;s++){
           System.out.println(arr[s]);
       }
   }

}

