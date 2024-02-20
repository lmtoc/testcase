package lc;

/**
 * 2024/1/17
 * lamic
 **/
public class LC123 {


    public int maxProfit(int[] prices) {
        //定义dp数组dp[i][j][k] 表示在第i天已经交易了j笔的当前手里钱值,k代表可以买还是可以卖，0是可以买，1是可以卖，初始化dp[0][0][0] = 0;dp[0][0][1] = -prices[0];
        //当k从1变成0，则j+1表示完成了一笔交易
        //转换：dp[i][j][0] = Math.max(dp[i-1][j-1][1]+prices[i],dp[i-1][j-1][0]);
        int[][][]dp = new int[prices.length][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = 0; //第一天不可能完成一笔交易
        dp[0][1][1] = - prices[0]; //可以是第二笔，只要不满足第二笔，那么都可以做返回结果

//        int maxResult = 0;
        for(int i = 1;i<prices.length;i++){
            //手上没有任何交易，同时也没有持股
            dp[i][0][0] = dp[i-1][0][0];
            //目前没有成为交易，但是持股
            dp[i][0][1] = Math.max(dp[i-1][0][1],dp[i-1][0][0]-prices[i]);
            //表示第i天已经有了一笔交易，同时当前可买入，也就是手上不持股
            dp[i][1][0] = Math.max(dp[i-1][0][1]+prices[i],dp[i-1][1][0]);
            //满了1笔交易,同时手上持股,最大值来源可能是前一天已经持有，也有可能当天买了
            dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][1][0]-prices[i]);


            //表示满了两笔交易，
            dp[i][2][0] = Math.max(dp[i-1][1][1]+prices[i],dp[i-1][2][0]);



        }
        return dp[prices.length-1][2][0];
    }

    public static void main(String[] args) {
        LC123 lc = new LC123();
        System.out.println(lc.maxProfit(new int[]{1,2,3,4,5}));
    }
}
