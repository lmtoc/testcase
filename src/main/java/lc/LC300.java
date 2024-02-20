package lc;

import java.util.Arrays;

/**
 * 2024/1/15
 * lamic
 **/
public class LC300 {

    //dp[i] 约定为到i位置的最长递增子序列是多长
    //dp[i] = Math.max(nums[i]>nums[i-1]?dp[i-1]+1:dp[i-1],)
    //dp[0] = 1; 初始化每个位置的最长子序列只有自己，那就是1
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[nums.length-1];
    }


    public static void main(String[] args){
        LC300 lc = new LC300();
        System.out.println(lc.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
