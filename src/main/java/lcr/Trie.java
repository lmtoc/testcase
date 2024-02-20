package lcr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Trie {
    LCRNode head = new LCRNode('/',false);
    LCRNode end = new LCRNode('<',true);
    /** Initialize your data structure here. */
    public Trie() {

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

    private LCRNode searchLastNode(String word){
        char[] allChars = word.toCharArray();
        LCRNode cur = head;
        int charIdx = 0;
        while(cur!= null && charIdx < allChars.length){
            if(cur.nextNodes.containsKey(allChars[charIdx])){
                cur = cur.nextNodes.get(allChars[charIdx]);  
            }else{
                return null;
            }
            charIdx++;
        }
        return cur;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        LCRNode lastChar = searchLastNode(word);

        if(lastChar != null&&lastChar.nextNodes.containsKey('<')){
            return true;
        }
        return false;

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        LCRNode lastNode = searchLastNode(prefix);
        return lastNode != null;
    }

    public static void main(String[] args) {
        MagicTrie trie = new MagicTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
//        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
        Collections.sort(new ArrayList<Integer>(), Comparator.reverseOrder());
    }


}

class LCRNode {
    Map<Character, LCRNode> nextNodes = new HashMap();
    char value;
    Boolean end;

    public LCRNode(char value, boolean end){
        for (Map.Entry<Character, LCRNode> entry : nextNodes.entrySet()) {

        }
        this.value = value;
        this.end = end;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */