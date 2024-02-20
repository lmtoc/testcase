package lcr;

import java.util.Arrays;

/**
 * 2024/1/29
 * lamic
 **/
public class LCR014 {
    public boolean checkInclusion(String s1, String s2) {
        int [] count = new int[26];  //记录具体每个字母差多少
        int differCharType = 0; //记录有差别的字母的个数
        for(Character car:s1.toCharArray() ){
            count[car-'a']++;
            if(count[car-'a'] == 1){
                differCharType++;
            }
        }
        int wLen = s1.length();

        //遍历s2处理窗口，如果当前char不在窗口中，复原count窗口,直接进行下一轮，如果包含则-1；
        //判断count是否都是0，是的话返回true

        int[] window = new int[26];
        window = Arrays.copyOfRange(count,0,26);
        int originDifferType = differCharType;
        char[] s2Char = s2.toCharArray();
        for(int i = 0;i<s2Char.length;i++){
            char car = s2Char[i];
//            if(count[car-'a'] == 0  ){ //遇到了不包含的字符，重新来一轮查找,或者是包含，但是早就清空了，也就是当前过多该字符
//                window = Arrays.copyOfRange(count,0,26);
//                differCharType = originDifferType;
//            }else{

                //包含但是仍在计算中
                window[car-'a']--;
                if(window[car-'a'] == 0){
                    differCharType--;
                }
                if(i>=wLen&& count[s2Char[i-wLen]-'a']  != 0){ //是包含在内的才要除去这个窗口，否则不声明为窗口
                    if(window[s2Char[i-wLen]-'a'] == 0){
                        differCharType++;
                    }
                    window[s2Char[i-wLen]-'a']++;
                }
                if(differCharType == 0){
                    return true;
                }
//            }

        }
        return false;
    }

    public static void main(String[] args) {
        LCR014 lc = new LCR014();
        System.out.println(lc.checkInclusion("pqzhi","ghrqpihzybre"));
        System.out.println(lc.checkInclusion("ab","eidbaooo"));
    }
}
