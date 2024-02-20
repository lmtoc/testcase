package lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LC433 {
    //依然是最短路径用bfs，每一个字母变换算一个步长
    static char [] items = new char[]{'T','A','G','C'};
    public static int minMutation(String startGene, String endGene, String[] bank) {
        if(bank == null || bank.length ==0){
            return -1;
        }
        Set<String> valid = Stream.of(bank).collect(Collectors.toSet());
        LinkedList<Map<String,Integer>>queue = new LinkedList();
        Map<String,Integer> start = new HashMap();
        start.put(startGene,0); //初始步长入对
        queue.offer(start);
        Set<String> visited = new HashSet();
        while(!queue.isEmpty()){
            Map<String,Integer> currentStrings = queue.poll();
            Map.Entry<String,Integer> currentString = null;
            for(Map.Entry<String,Integer> entry:currentStrings.entrySet()){
                currentString = entry;
            }

            if(currentString ==null || visited.contains(currentString.getKey())){ //避免成环
                continue;
            }
            visited.add(currentString.getKey());
            //针对当前字符串，在8个位置中变形
            String gene = currentString.getKey();

            for(int i = 0;i<8;i++){ //8是定长
                for(char item:items){ //对字符串i位置字母开始变换
                    if(gene.charAt(i) == item){ //一样不用变
                        continue;
                    }
                    char [] geneChar = gene.toCharArray();
                    geneChar[i] = item;
                    String change = new String(geneChar);
                    if(!valid.contains(change)){
                        continue;
                    }
                    if(change.equals(endGene)){
                        return currentString.getValue()+1;
                    }
                    Map<String,Integer> changeMap = new HashMap();
                    changeMap.put(change,currentString.getValue()+1);
                    queue.offer(changeMap);
                }
            }
        }

        return -1;
    }

    public  static void main(String[] args){
        System.out.println(minMutation("AACCGGTT","AACCGGTA",new String[]{"AACCGGTA"}));
    }
}