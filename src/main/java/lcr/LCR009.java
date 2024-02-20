package lcr;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024/1/29
 * lamic
 **/
public class LCR009 {
    List<List<Integer>> result = new ArrayList();
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<k){
                ArrayList<Integer> curResult = new ArrayList();
                curResult.add(nums[i]);
                dfs(nums,k,i+1,curResult,nums[i]);
            }
        }
        return result.size();
    }

    private void dfs(int[] nums,int k,int curIdx,List<Integer> curResult,int curPlus){ //看清题目，连续子数组
        if(curResult.size()>=1){
            result.add(new ArrayList(curResult));
        }
        if(curIdx>=nums.length){ //乘当前项
            return;
        }

        if(nums[curIdx]*curPlus >= k){
            return;
        }

        curResult.add(nums[curIdx]);
        dfs(nums,k,curIdx+1,curResult,nums[curIdx]*curPlus);
        curResult.remove(curResult.size()-1);
    }


    public static void main(String[] args) {
        LCR009 lc = new LCR009();
        System.out.println(lc.numSubarrayProductLessThanK(new int[]{10,5,2,6},100));
    }


}
