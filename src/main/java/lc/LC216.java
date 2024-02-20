package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 2024/1/4
 * lamic
 **/
public class LC216 {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,0,n,k,new ArrayList());
        return result;
    }


    private void dfs(int current,int currentSum,int target,int k,List<Integer> currentResult){
        if(currentResult.size() == k && currentSum == target){
            result.add(new ArrayList(currentResult));
            return;
        }
        if(currentResult.size() >= k || current >target){
            return;
        }
        int rest =target-currentSum;
        for(int i = current;i<=rest && i<9;i++){
            int sum = currentSum+i;
            currentResult.add(i);
            dfs(i+1,sum,target,k,currentResult);
            currentResult.remove(currentResult.size()-1);
        }
    }

    public static void main(String[] args){
        LC216 lc = new LC216();
        lc.combinationSum3(2,18);
    }
}
