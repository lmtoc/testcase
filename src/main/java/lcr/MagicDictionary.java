package lcr;

import java.util.HashMap;
import java.util.Map;

class MagicDictionary {
    MagicTrie trie = new MagicTrie();

    /** Initialize your data structure here. */
    public MagicDictionary() {

    }
    
    public void buildDict(String[] dictionary) {
        if(dictionary == null || dictionary.length == 0){
            return ;
        }
        for(String word:dictionary){
            trie.insert(word);
        }

    }
    
    public boolean search(String searchWord) {
        return trie.search(searchWord);
    }


    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello","hallo","leetcode"});
        System.out.println(magicDictionary.search("hello"));
        System.out.println(magicDictionary.search("hallo"));
        System.out.println(magicDictionary.search("hhllo"));
        System.out.println(magicDictionary.search("hell"));
        System.out.println(magicDictionary.search("leetcoded"));
    }
}

class MagicTrie {
    LCRNode head = new LCRNode('/',false);
    LCRNode end = new LCRNode('<',true);
    /** Initialize your data structure here. */
    public MagicTrie() {

    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] allChars = word.toCharArray();
        LCRNode cur = head;
        int charIdx = 0;
        while(cur!= null&& charIdx < allChars.length){
            if(cur.nextNodes.containsKey(allChars[charIdx])){
                cur = cur.nextNodes.get(allChars[charIdx]);  
            }else{
                LCRNode newNode = new LCRNode(allChars[charIdx],false);
                cur.nextNodes.put(allChars[charIdx],newNode);;
                cur = newNode;
            }
            charIdx++;
        }
        cur.nextNodes.put('<',end);

    }

    public boolean search(String word){
        char[] allChars = word.toCharArray();
        LCRNode cur = head;
        int charIdx = 0;
        int hitFail = 0;
        while(cur!= end && charIdx < allChars.length){
            if(cur.nextNodes.containsKey(allChars[charIdx])){
                cur = cur.nextNodes.get(allChars[charIdx]);
            }else if(hitFail > 0 ){ //长度不一致的情况
                return false;
            }else if(charIdx < allChars.length-1){
                boolean canHit = false;
                hitFail++;
                //skip the error one find cur
                for(Map.Entry<Character,LCRNode> entry:cur.nextNodes.entrySet()){
                    LCRNode next = entry.getValue();
                    if(next.nextNodes.containsKey(allChars[charIdx+1])){
                        cur = next;
                        canHit = true;
                        break;
                    }
                }
                if(!canHit){
                    return false;
                }

            }
            charIdx++;
        }
        if(hitFail == 0){ //完全命中
            return false;
        }
        return true;
    }







}

//class LCRNode {
//    Map<Character, LCRNode> nextNodes = new HashMap();
//    char value;
//    Boolean end;
//
//    public LCRNode(char value, boolean end){
//        this.value = value;
//        this.end = end;
//    }
//}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */