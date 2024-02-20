package lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 2023/12/27
 * lamic
 **/
public class LC127 {

    public static void main(String [] args){
        System.out.println(ladderLength("qa","sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0){
            return 0;
        }
        Set<String> valid = new HashSet(wordList);
        if(! valid.contains(endWord)){
            return 0;
        }
        LinkedList<String> queue = new LinkedList();//队列里面存的是当前可以处理的字符串，也就是bfs过程中访问到的字符串
        Map<String,Integer> wordToStep = new HashMap(); //到达该word需要消耗的步长，放在这里是为了降低代码复杂度，其实跟着word一起放在queue中更清晰，但是map不好取数
        Set<String> visited = new HashSet(); //避免重复计算，word访问一次就不处理
        Set<String> node = new HashSet(); //避免重复计算，word访问一次就不处理
        wordToStep.put(beginWord,1);//初始步长
        queue.offer(beginWord); //从输入开始处理

        int wordLength = endWord.length(); //题干说的，都一样长
        //bfs
        while(!queue.isEmpty()){
            String current = queue.poll();
            if(visited.contains(current)){ //避免重复扩散
                continue;
            }
            visited.add(current);
            //对当前字符的每个位置进行26个字母变换
            char[] wordChar = current.toCharArray();
            for(int i = 0;i<wordLength;i++){
                char origin = wordChar[i];
                for(char j='a';j<='z';j++){
                    if(j == origin){
                        continue;
                    }
                    wordChar[i] = j;
                    String changeString = new String(wordChar);
                    if(!valid.contains(changeString)){
                        continue;
                    }
                    if(visited.contains(changeString) || node.contains(changeString)){
                        continue;
                    }
                    if(changeString.equals(endWord)){
                        return wordToStep.get(current)+1;
                    }else{
                        queue.offer(changeString);
                        wordToStep.put(changeString,wordToStep.get(current)+1);
                        node.add(changeString);
                    }

                }
                wordChar[i] = origin;
            }
        }
        return -1;
    }
}
