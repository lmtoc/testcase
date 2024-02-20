package lc;

/**
 * 2024/1/16
 * lamic
 **/
public class LC63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //设动态数组 dp[i][j]代表当前到[i,j]的路径方式
        //如果原始数组当前是1，那么设置为0，因为永远到不了；否则则是两边路叠加
        int m = obstacleGrid.length;
        int n = obstacleGrid[m-1].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }

        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            if(obstacleGrid[i][0] == 0){
                dp[i][0] = 1; //只有从上到下一条路径
            }else{ //一旦遇到障碍，则这条路障碍下的都不可达
                break ;
            }
        }


        for(int i = 0;i<n;i++){
            if(obstacleGrid[0][i] == 0){
                dp[0][i] = 1; //只有从上到下一条路径
            }else{ //一旦遇到障碍，则这条路障碍下的都不可达
                break ;
            }
        }


        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        LC63 lc = new LC63();
        System.out.println(lc.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
