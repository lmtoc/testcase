package lc;

import java.util.List;

/**
 * 2024/1/16
 * lamic
 **/
public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 定义dp数组dp[i][j] 含义为到达[i,j]的最小路径和，体感信息判断是一定可达，所以最终没有不可达判断，能否用贪心
        // 我们从底到顶底腿，最终结果取 dp[0][0]即可；
        // 初始化底行： dp[i][j] = triangle[i][j];
        // 转化方程：dp[i][j] = Math.min(dp[i+1][j+1],dp[i+1][j]);只能走相邻的
        int depth = triangle.size();
        int width = triangle.get(depth-1).size();
        int[][]dp = new int[depth][width];
        //初始化
        for(int j = 0;j<width;j++){
            dp[depth-1][j] = triangle.get(depth-1).get(j);
        }

        for(int i = depth-2;i>=0;i--){
            for(int j = 0;j<=i;j++){ //这里j以上层数量为准
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);

            }
        }
        return dp[0][0];

    }


    public static void main(String [] args){
        LC120 lc = new LC120();
        lc.minimumTotal(List.of(List.of(2),List.of(3,4),List.of(6,5,7),List.of(4,1,8,3)));
    }
}
