package lc;

/**
 * 2024/1/10
 * lamic
 **/
public class LC67 {
    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int aIndex = aLength-1;
        int bIndex = bLength-1;
        int exp = 0;
        StringBuilder sb = new StringBuilder();
        while(aIndex >= 0 || bIndex >=0){
            Integer value = exp;
            value = aIndex < 0?value:(int)a.charAt(aIndex--)-'0'+value;
            value = bIndex < 0?value:(int)b.charAt(bIndex--)-'0'+value;
            exp = value/2;
            value = value%2;
            sb.insert(0,value);
        }


        if(exp > 0){
            sb.insert(0,exp);
        }
        return sb.toString();
    }


    public static void main(String[] args){
        LC67 lc = new LC67();
        System.out.println(lc.addBinary("1010","10111"));
    }
}
