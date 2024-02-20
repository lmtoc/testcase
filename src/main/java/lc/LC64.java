package lc;

/**
 * 2024/1/16
 * lamic
 **/
public class LC64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[m-1].length;

        int[][]dp = new int[m][n];
        //初始值：因为一定可达所以不需要特殊标识,j=0的一行初始化为自己，i=0的一行初始化为自己
        //转移方程dp[i][j]标识到达[i,j]的最小和累积，dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j]值来源只能是上面或者左边，根据贪心我们选更小的那个
        for(int j = 0;j<n;j++){
            dp[0][j] = grid[0][j];
        }

        for(int i = 0;i<m;i++){
            dp[i][0] = grid[i][0];
        }
        dp[0][0] = grid[0][0];
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        LC64 lc = new LC64();
        lc.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
}
