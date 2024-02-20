package lc;

/**
 * 2024/1/12
 * lamic
 **/
public class LC70 {
    public int climbStairs(int n) {
        if(n < 3){
            return n;
        }
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for(int i = 3;i<n+1;i++){
            result[i] = result[i-1]+result[i-2];
        }
        return result[n];
    }
    public static void main(String [] args){
        LC70 lc = new LC70();
        lc.climbStairs(5);
    }
}
