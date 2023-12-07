package lc;

/**
 * 2023/12/7
 * lamic
 **/
public class LC125 {

    public static boolean isPalindrome(String s) {
        if(s.length() <= 1){
            return true;
        }
        char[] charArray = s.toLowerCase().toCharArray();
        int i = 0;
        int j = charArray.length-1;
        while( i < j ){
            if((charArray[i]>57 ||charArray[i]<48)&&charArray[i]<97 || charArray[i]>122){
                i++;
                continue;
            }
            if((charArray[j]>57 ||charArray[j]<48)&&charArray[j]<97 || charArray[j]>122){
                j--;
                continue;
            }
            if(charArray[i] != charArray[j]){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    public static  void main(String [] args){
        System.out.println(isPalindrome("0P"));
    }
}
