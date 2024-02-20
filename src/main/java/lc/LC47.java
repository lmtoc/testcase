package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024/1/3
 * lamic
 **/
public class LC47 {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(nums,0,new ArrayList(),used);
        return result;
    }

    //这是第currentIndex层的选择
    private void dfs(int[] nums,int depth,List<Integer> currentResult,boolean[]used){
        if(currentResult.size() >= nums.length ||depth >= nums.length){
            result.add(new ArrayList(currentResult));
            return;
        }

        boolean [] levelUsedValue = new boolean[21];
        for(int i = 0;i<nums.length;i++){
            if(used[i] || levelUsedValue[nums[i]+10]){
                continue;
            }
            used[i] = true;
            levelUsedValue[nums[i]+10] = true;
            currentResult.add(nums[i]);
            dfs(nums,depth+1,currentResult,used);
            //这里应该优先removeIndex 不然相同数字会出问题
            currentResult.remove(currentResult.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args){
        LC47 lc = new LC47();
        System.out.println(lc.permuteUnique(new int[]{2,2,1,1}));
    }
}
