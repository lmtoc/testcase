package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 2023/12/12
 * lamic
 **/
public class LC383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> charToTime = new HashMap();
        for(Character currentChar:ransomNote.toCharArray()){
            if(charToTime.containsKey(currentChar)){
                charToTime.put(currentChar,charToTime.get(currentChar)+1);
            }else{
                charToTime.put(currentChar,1);
            }
        }

        for(Character currentChar:magazine.toCharArray()){
            if(charToTime.containsKey(currentChar)){
                charToTime.put(currentChar,charToTime.get(currentChar)-1);
            }
            if(charToTime.containsKey(currentChar)&&charToTime.get(currentChar) == 0){
                charToTime.remove(currentChar);
            }
            if(charToTime.isEmpty()){
                return true;
            }
        }
        return charToTime.isEmpty();

    }


    public static void main(String []args){
        System.out.println(canConstruct("aa","aab"));
    }
}
