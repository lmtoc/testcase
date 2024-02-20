package lc;

/**
 * 2024/1/22
 * lamic
 **/
public class LC1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int maxResult = 0;
        //dp[i][j]数组为到text1第i位到数组test2的第j位的当前最长公共子序列长度
        //转换方程为 dp[i][j] = text1[i] == text2[j]? dp[i-1][j-1]+1:dp[i-1][j-1];
        //初始化：dp[0][j] =  text1[0] == text2[j]?1:0
        // dp[i][0]同理
        if(text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0){
            return 0;
        }
        int t1Length = text1.length();
        int t2Length = text2.length();
        int[][]dp = new int[t1Length][t2Length];
        dp[0][0] = text1.charAt(0) == text2.charAt(0)?1:0;
        for(int i = 1;i<t1Length;i++){
            dp[i][0] = text1.charAt(i) == text2.charAt(0)?1:dp[i-1][0];
        }

        for(int i = 1;i<t2Length;i++){
            dp[0][i] = text1.charAt(0) == text2.charAt(i)?1:dp[0][i-1];
        }

        for(int i = 1;i<t1Length;i++){
            for(int j = 1;j<t2Length;j++){
                int base = Math.max(Math.max(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1]);
                dp[i][j] = text1.charAt(i) == text2.charAt(j)?base+1:base;
            }
        }
        return dp[t1Length-1][t2Length-1];
    }

    public static void main(String[] args) {
        LC1143 lc = new LC1143();
        lc.longestCommonSubsequence("bsbininm","jmjkbkjkv");
    }
}
