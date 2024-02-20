package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2024/1/4
 * lamic
 **/
public class LC40 {

    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,0,target,new ArrayList());
        return result;
    }

    private void dfs(int[] candidates, int curIndex, int curSum, int target, List<Integer> curResult){
        if(curSum == target){
            result.add(new ArrayList(curResult));
            return;
        }
        if(curIndex >= candidates.length || curSum>target){
            return;
        }
        //同一层去重
        boolean[]used = new boolean[51];
        for(int i = curIndex;i<candidates.length;i++){
            if(used[candidates[i]]){
                continue;
            }
            used[candidates[i]] = true;
            curResult.add(candidates[i]);
            dfs(candidates,i+1,curSum+candidates[i],target,curResult);
            curResult.remove(curResult.size()-1);
        }

    }

    public static void  main(String[] args){
        LC40 lc = new LC40();

        List<TreeNode> nodes = new ArrayList<>();
        nodes.sort(Comparator.comparing(treeNode -> (-treeNode.val)));
        System.out.println(lc.combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}
