package lc;

/**
 * 2024/1/22
 * lamic
 **/
public class LC416 {

    public boolean canPartition(int[] nums) {
        //dp[i]为和是否能为i
        //转移方程： dp[i] = dp[i]-nums[j] == true;
        //初始化 dp[nums[i]] = true;
        //和如果是奇数一定不能达到
        int length = nums.length;
        boolean [] dp = new boolean[101*length/2];
        int total = 0;
        dp[0] = true;
        for(int i = 0;i<length;i++){
            dp[nums[i]] = true;
            total+=nums[i];

            dp[total]= true;
        }
        if(total %2 ==1){
            return false;
        }

        for(int j = 0;j<length;j++){
            for(int i = nums[j]+1;i<=total/2;i++){
                dp[i] = dp[i-nums[j]];
            }
        }
        return dp[total/2];
    }

    public static void main(String[] args) {
        LC416 lc = new LC416();
        System.out.println(lc.canPartition(new int[]{1,2,5}));
    }
}
