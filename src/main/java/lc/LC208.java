package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 2023/12/29
 * lamic
 **/
public class LC208 {
    static final char SPECIAL = '/';
    static Node head = new Node(SPECIAL);
    static Node tail = new Node(SPECIAL);  //树枝插结束的编制，表示插入过字符串



    public static void insert(String word) {
        Map<Node,Integer>lastNodeAndIndex = findLastNode(word,head);
        Node lastValidNode = null;
        Integer firstNotValidIndex = -1;
        for(Map.Entry<Node,Integer> entry:lastNodeAndIndex.entrySet()){
            lastValidNode = entry.getKey();
            firstNotValidIndex = entry.getValue();
        }
        if(firstNotValidIndex >= word.length()){
            lastValidNode.addNextNode(SPECIAL,tail);
            return;
        }
        Node newNode = construct(word.toCharArray(),firstNotValidIndex);
        lastValidNode.addNextNode(word.toCharArray()[firstNotValidIndex],newNode);

    }

    private static Map<Node,Integer> findLastNode(String word,Node begin){
        char[] letters = word.toCharArray();
        Node current = begin;
        int i = 0;
        //找到最后一个能与word匹配上的node
        while(i<letters.length && current != null && current.nextNodes != null && current.nextNodes.containsKey(letters[i])){
            current = current.nextNodes.get(letters[i]);
            i++;
        }
        Map<Node,Integer> result = new HashMap();
        result.put(current,i);
        return result;
    }

    private static Node construct(char[] letters,int fromIndex){
        Node head = new Node('.');
        Node current = head;
        for(int i = fromIndex;i < letters.length;i++){
            Node nextNode = new Node(letters[i]);
            current.addNextNode(letters[i],nextNode);
            current = nextNode;
        }
        current.addNextNode(SPECIAL,tail);
        return head.nextNodes.get(letters[fromIndex]);
    }

    public static  boolean search(String word) {
        Map<Node,Integer>lastNodeAndIndex = findLastNode(word,head);
        Node lastValidNode = null;
        Integer firstNotValidIndex = -1;
        for(Map.Entry<Node,Integer>  entry:lastNodeAndIndex.entrySet()){
            lastValidNode = entry.getKey();
            firstNotValidIndex = entry.getValue();
        }
        //要么树枝插没走完，要么字符串没走完
        if(!lastValidNode.nextNodes.containsKey(SPECIAL) || firstNotValidIndex < word.length() ){
            return false;
        }
        return true;
    }

    public static boolean startsWith(String prefix) {
        Map<Node,Integer> lastNodeAndIndex = findLastNode(prefix,head);
        Node lastValidNode = null;
        Integer firstNotValidIndex = -1;
        for(Map.Entry<Node,Integer>  entry:lastNodeAndIndex.entrySet()){
            lastValidNode = entry.getKey();
            firstNotValidIndex = entry.getValue();
        }
        //字符串没走完则不包含
        return firstNotValidIndex >= prefix.length();
    }



    public static void main(String [] args){
//          insert("apple");
//          System.out.println(search("apple"));
//          System.out.println(search("app"));
//          System.out.println(startsWith("app"));
//          insert("app");
//          System.out.println(search("app"));
        System.out.println(startsWith("a"));

    }
}



//每个字母节点都封装成node，目的是比较好做参数
class Node{
    Character nodeVal;

    Map<Character,Node> nextNodes = new HashMap();

    public Node(Character nodeVal){
        this.nodeVal = nodeVal;
    }


    public boolean addNextNode(char nextChar,Node nextNode){
        this.nextNodes.put(nextChar,nextNode);
        return true;
    }
}



