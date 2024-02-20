package lc;

/**
 * 2024/1/12
 * lamic
 **/
public class LC50 {

    public double myPow(double x, int n) {
        if(n == 0 ){
            return 1;
        }
        if(x == 1.0d || x == 0.0d){
            return x;
        }


        int times = Math.abs(n);
        double result = 1.0d;
        while(times-->0){
            result *= x;
        }

        if(n < 0){
            result = 1/result;
        }
        return result;

    }


    public static void main(String [] args){
        LC50 lc = new LC50();
        lc.myPow(2,Integer.MIN_VALUE);
    }
}
