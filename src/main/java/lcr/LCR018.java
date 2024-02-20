package lcr;

/**
 * 2024/2/1
 * lamic
 **/
public class LCR018{
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length()-1;
            while(left< right){
                char rightC = s.charAt(right);
                char leftC = s.charAt(left);
                if(!(rightC>='A' && rightC<='Z' || rightC>='a' && rightC<='z'|| rightC >='0' && rightC <='9')){
                    right--;
                    continue;
                }
                if(!(leftC>='A' && left<='Z'|| leftC>='a' && left<='z' || leftC >='0' && leftC <='9')){
                    left++;
                    continue;
                }
                if(leftC>='A' && left<='Z'|| leftC>='a' && left<='z'){
                    if(rightC >= '0' && rightC <= '9' || (rightC != leftC && rightC-leftC!=32 && leftC-rightC!=32)){
                        return false;
                    }
                }else if(leftC >='0' && leftC <='9'){
                    if(rightC !=leftC ){
                        return false;
                    }
                }
                left++;
                right--;
            }
            return true;

        }

        public static void main(String[] args) {
            LCR018 lcr018 = new LCR018();
            System.out.println(lcr018.isPalindrome("Marge, let's \"[went].\" I await {news} telegram."));
        }
}
