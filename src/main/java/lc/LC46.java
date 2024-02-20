package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024/1/2
 * lamic
 **/
public class LC46 {

    static List<List<Integer>> result = new ArrayList();
    public static List<List<Integer>> permute(int[] nums) {
        dfs(nums,0,new ArrayList());
        return result;

    }

    private static void dfs(int[] nums,int currentIndex,List<Integer> currentResult){

        if(currentResult.size() == nums.length){
            result.add(new ArrayList(currentResult));
            return;
        }
        //判决是否剪枝
        if(currentIndex >= nums.length){
            return;
        }

        //当前路径先加在dfs
        currentResult.add(nums[currentIndex]);
        dfs(nums,currentIndex+1,currentResult);
        //当前路径先dfs再加
        currentResult.remove(Integer.valueOf(nums[currentIndex]));
        dfs(nums,currentIndex+1,currentResult);
        currentResult.add(nums[currentIndex]);
    }


    public static void main(String[] args){
        System.out.println(permute(new int[]{1,2,3}));
    }
}
