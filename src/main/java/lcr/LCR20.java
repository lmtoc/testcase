package lcr;

/**
 * 2024/2/1
 * lamic
 **/
public class LCR20 {
    public int countSubstrings(String s) {

        //双指针，固定左指针，扩大右指针
        //开始计算条件：右指针的字符与左指针相等
        //结束后处理：左指针+1；右指针从左指针+1处重新寻找
        int result = s.length(); //答案初始化是字符串长度，因为单个字符是回文串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    int start = i;
                    int end = j;
                    while (start < end && s.charAt(start) == s.charAt(end)) {
                        start++;
                        end--;
                    }
                    if (start >= end ) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LCR20 lcr20 = new LCR20();
        System.out.println(lcr20.countSubstrings("aaabbaaa"));
    }
}
