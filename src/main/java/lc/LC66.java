package lc;

/**
 * 2024/1/11
 * lamic
 **/
public class LC66 {
    public int[] plusOne(int[] digits) {
        int exp = 1;
        int length = digits.length;

        for(int i = length-1;i>=0;i--){

            digits[i] = digits[i]+exp;
            if(digits[i] >= 10){
                exp = digits[i]/10;
                digits[i] = digits[i]%10;
            }else{
                exp = 0;
                break;
            }

        }
        if( exp > 0){
            int[] result = new int[length+1];
            result[0] = exp;
            for(int i = 0;i<length;i++){
                result[i+1] = digits[i];
            }
        }
        return digits;
    }

    public static void main(String args[]){
        LC66 lc = new LC66();
        lc.plusOne(new int[]{9});

    }
}
