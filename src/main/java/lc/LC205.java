package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 2023/12/12
 * lamic
 **/
public class LC205 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> sCharTotChar = new HashMap();
        boolean[]tCharUsed = new boolean[26];
        for(int i = 0;i<s.length();i++){
            if(i>t.length()){
                return false;
            }
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            if(sCharTotChar.containsKey(sChar) && sCharTotChar.get(sChar).equals(tChar)){

                continue;
            }else if(!sCharTotChar.containsKey(sChar)){
                if(tCharUsed[tChar - 'a']){
                    return false;
                }
                tCharUsed[tChar-'a'] = true;
                sCharTotChar.put(sChar,tChar);
            }else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args){
        System.out.println(isIsomorphic("badc","baba"));
    }
}
