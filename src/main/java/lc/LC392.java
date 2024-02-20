package lc;

/**
 * 2023/12/8
 * lamic
 **/
public class LC392 {

    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        while(tIndex < t.length() && sIndex <s.length()){
            if(t.charAt(tIndex) == s.charAt(sIndex)){
                sIndex++;
            }

            tIndex++;
        }
        return sIndex == s.length();
    }

    public static void main(String[] args){
        System.out.println(isSubsequence("","ahbgdc"));
    }
}
