package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024/1/3
 * lamic
 **/
public class LC39 {
    static List<List<Integer>> result = new ArrayList();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,0,0,target,new ArrayList());
        return result;
    }

    private static  void dfs(int[] candidates,int currentSum,int currentIndex,int target,List<Integer> currentResult){
        if(currentSum == target){
            result.add(new ArrayList(currentResult));
            return;
        }
        if(currentIndex >= candidates.length || currentSum > target){
            return;
        }
        dfs(candidates,currentSum,currentIndex+1,target,currentResult);
        currentResult.add(candidates[currentIndex] );
        dfs(candidates,currentSum+candidates[currentIndex],currentIndex,target,currentResult);
        currentResult.remove(Integer.valueOf(candidates[currentIndex]));

    }


    public static void main(String[] args){
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
}
