package lc;

import java.util.Arrays;
import java.util.Collections;

/**
 * 2024/1/22
 * lamic
 **/
public class LC473 {
    int[] buckets = new int[4];
    int each = 0;
    //这道题可以转化成 是否能分成total/4的4个集合,最后4个集合的值相加相等
    public boolean makesquare(int[] matchsticks) {
        int len = matchsticks.length;
        int total = 0;
        Integer [] numbers = new Integer[len];
        for(int i = 0;i<len;i++){
            total+= matchsticks[i];
            numbers[i] = matchsticks[i];
        }

        if(total%4 != 0){
            return false;
        }
        each = total/4;
        Arrays.sort(numbers, Collections.reverseOrder());
        return dfs(numbers,0);
    }


    private boolean dfs(Integer[] nums,int curIdx){
        if(curIdx >= nums.length){
            return buckets[0] == buckets[1] && buckets[1] == buckets[2] && buckets[2] == buckets[3];
        }
        for(int i = curIdx;i<nums.length;i++){

            for(int j = 0;j<4;j++){
                if(j > 0 &&buckets[j] == buckets[j-1]){
                    continue;
                }
                if(buckets[j]+nums[i] > each ){
                    continue;
                }
                buckets[j]+=nums[i];
                if(dfs(nums,i+1)){
                    return true;
                }
                buckets[j]-=nums[i];
            }
        }
        return false;
    }


    public static void main(String[] args) {
        LC473 lc = new LC473();
        System.out.println(lc.makesquare(new int[]{3,3,3,3,4}));
    }
}
