package LeetCode.easy;


public class numAdd {

    public static void main(String args[]){
        int nums[] = {2, 7,3, 11, 15,8,6,1};
        int target = 9;
        int  b[] = twoSum(nums,target);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int a[] = new int[nums.length];
        int b = 0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=1+i;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    a[b]=i;
                    a[b+1]=j;
                    b+=2;
                }
            }
        }
        int test[] =new int[b];
        for(int s=0;s<b;s++){
            test[s]=a[s];
        }
        return test;
    }
}
