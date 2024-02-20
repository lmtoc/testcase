package lc;

/**
 * 2024/1/12
 * lamic
 **/
public class LC69 {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int left = 1;
        int right = x/2;
        while(left < right){
            //这里mid一定要+1，这个区分于数组的整数元素，mid很有可能保持原状因为比如（1，4）还有（2，3）都是2，卡死
            //先前是乘法版本，现在溢出了，改除法
            int mid = left+(right-left+1)/2;
            int current = x/mid;
            if(current == mid){
                return mid;
            }
            //这里说明剩下的有点多，说明左边需要缩小位置，右边不动
            if(current > mid){ //大了能选小的，这里-1没问题
                right = mid-1;
            }else{
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args){
        LC69 lc = new LC69();
        System.out.println(lc.mySqrt(8));

    }
}
