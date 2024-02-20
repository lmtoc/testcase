package lcr;

/**
 * 2024/2/3
 * lamic
 **/
public class LCR034 {

    public boolean isAlienSorted(String[] words, String order) {
        //比较单词每个位置的字母在order中的位置大小，空白字符最小，所以最短的字符最小
        //越大越靠前
        //初始化字典表，记录charToIndex
        //两两比较字符串中，同一位字符比较，比较在字典表中的位置一位比一位靠前，也就是小；这样可以判断相同前缀的场景
        int[] dict = new int[26];
        for(int i = 0;i<order.length();i++){
            dict[order.charAt(i)-'a'] = i;
        }

        for(int i = 0;i<words.length-1;i++){
            boolean equalPrefix = true;
            //比较当前字符串的j位与下一字符串的j位
            for(int j = 0;j<words[i].length() && j<words[i+1].length();j++){
                int prev = words[i].charAt(j)-'a';
                int next = words[i+1].charAt(j)-'a';
                if(dict[prev] > dict[next]){ // 字典表中index值越大，字典序越小
                    return false;
                }else if(dict[prev] < dict[next]){
                    equalPrefix = false;
                    break; //在之前字典序相等的情况，遇到第一个符合字典序的字母就可以判定大
                }
            }
            if(equalPrefix && words[i].length() < words[i+1].length()){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        LCR034 lcr034 = new LCR034();
        lcr034.isAlienSorted(new String[]{"apple","leetcode"},"hlabcdefgijkmnopqrstuvwxyz");
    }
}
