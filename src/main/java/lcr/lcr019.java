package lcr;

/**
 * 2024/2/1
 * lamic
 **/
public class lcr019 {
    public boolean validPalindrome(String s) {
        if(s == null ||s.length() == 0){
            return true;
        }
        int cheatTime = 0;
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);
            if(charLeft!= charRight){
                if(cheatTime == 1){
                    return false;
                }else{
                    if( s.charAt(left+1) == charRight){
                        left++;
                    }else if( s.charAt(right-1) == charLeft){
                        right--;
                    }
                    cheatTime++;
                    continue;
                }

            }

            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        lcr019 lcr019 = new lcr019();
        System.out.println(lcr019.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
