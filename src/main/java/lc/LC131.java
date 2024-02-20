package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2024/1/23
 * lamic
 **/
public class LC131 {
    List<List<String>> result = new ArrayList();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList());
        return result;
    }

    private void dfs(String s,int sIndex,List<String> currentResult){
        if(sIndex >= s.length()){ //说明字符串检查完了
            result.add(new ArrayList<>(currentResult));
            return ;
        }

        for(int i = sIndex;i<s.length();i++){
            String fir = s.substring(sIndex,i+1);
            if(!isPalindom(fir)){
                continue;
            }
            currentResult.add(fir);
            dfs(s,i+1,currentResult);
            currentResult.remove(currentResult.size()-1);
//            dfs(sec,currentResult);
        }

    }

    private boolean isPalindom(String s){
        if(s.isEmpty()){
            return false;
        }
        if(s.length() == 1){
            return true;
        }
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;

    }


    public static int maxProduct(String[] words) {
        Map<String,Set<Character>> wordToSet = new HashMap<>();

        for(String word:words){
            if(word.isEmpty()){
                continue;
            }
            Set<Character> set = new HashSet<>();
            for (char chars : word.toCharArray()) {
                set.add(chars);
            }
            wordToSet.put(word, set);

        }

        int maxResult = 0;
        for(int i = 0;i<words.length;i++){
            Set<Character> iChar = wordToSet.get(words[i]);
            for(int j = i+1;j<words.length;j++){
                for(Character ca:wordToSet.get(words[j])){
                    if(iChar.contains(ca)){
                        break;
                    }
                }
                maxResult = Math.max(maxResult,words[i].length()*words[j].length());
            }
        }
        return maxResult;

    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
//        LC131 lc = new LC131();
//        System.out.println(lc.partition("aab"));
//        Map<String, Set<Character>> wordToSet = new HashMap<>();
//
//        for(String word:args){
//            if(word.isEmpty()){
//                continue;
//            }
//            Set<Character> set = new HashSet<>();
//            for (char chars : word.toCharArray()) {
//                set.add(chars);
//            }
//            wordToSet.put(word, set);
//
//        }
    }
}
