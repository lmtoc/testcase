package lcr;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer,Node> keyToValue = new HashMap();
    Node head = new Node();
    Node tail = new Node();

    int capacity = 0;
    int size = 0;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = keyToValue.get(key);
        if(node == null){
            return -1;
        }
        reHot(node);
        return node.val;

    }
    
    public void put(int key, int value) {
        Node node = keyToValue.get(key);
        if(node != null){
            node.val = value;
            reHot(node);
            keyToValue.put(key,node);
        }else{
            if(size == capacity){
                Node last = evictTail();
                keyToValue.remove(last.key);
                size--;
            }
            Node newNode = new Node(key,value);
            initHot(newNode);
            keyToValue.put(key,newNode);
            size++;
        }
    }
    private void initHot(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head; 
    }

    private Node evictTail(){
        Node last = tail.prev;
        tail.prev = last.prev;
        last.prev.next = tail;

        last.next = null;
        last.prev = null;
        return last;
        
    }

    private void reHot(Node node){
        //改变node的位置，使他移到head下一个，当前最热
        //node的
        Node next = node.next;
        next.prev = node.prev;
        node.prev.next = next;
        //头的
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head; 

        
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5,5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }
}

class Node{
    Node prev;
    Node next;
    Integer val;
    Integer key;

    public Node (){

    }

    public Node(int key,int value){
        this.key = key;
        this.val = value;
    }
}
