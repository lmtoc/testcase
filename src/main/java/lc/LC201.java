package lc;

/**
 * 2024/1/11
 * lamic
 **/
public class LC201 {

    public int rangeBitwiseAnd(int left, int right) {
        if(left == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(left == 0){
            return 0;
        }
        int result = left;
        while(++left <= right){
            result = left&result;
            if(result == 0 || left == Integer.MAX_VALUE){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        LC201 lc = new LC201();
        System.out.println(lc.rangeBitwiseAnd(2147483646,2147483647));
    }
}
