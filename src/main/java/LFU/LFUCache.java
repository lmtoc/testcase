package LFU;/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU 缓存


 实现 LFUCache 类：

LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。

当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。

函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

// @lc code=start
class LFUCache {

    private Map<Integer,Node> cacheMap = new HashMap();

    //当前使用的数量
    private int size = 0;

    //支持的容量
    private int capacity = 0;

    //当前最小的频次，会有更新的场景
    private int min = 0;

    //这里用linkedHashSet，是因为题干要求频次一样的按照插入顺序，越旧越优先移除
    private Map<Integer,LinkedHashSet<Node>>freToNode = new HashMap();

    public LFUCache(int capacity) {
        this.capacity = capacity;
       
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        Node nodeVal = cacheMap.get(key);
        incFreq(nodeVal);
        return nodeVal.value;

    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){ //更新value值以及更新feq访问频次
            Node exisNode = cacheMap.get(key);
            exisNode.value = value;
            incFreq(exisNode);
        }else{
            //如果当前size没有超过capacity，直接初始化加入
            if( size  ==  capacity){
                Node evictNode = evictMinNode();
                if(evictNode != null){
                    cacheMap.remove(evictNode.key);
                }
                size -- ;

            } //如果超过，则丢弃访问最少的node，并插入node

                Node addNode = addNode(key,value);
                cacheMap.put(key, addNode);
                size++;


            
        }


        
    
    }



    public void incFreq(Node node){
        int feq = node.frequent;
        //更新node的访问频次字段，并将node从原访问频次的集合中移除
        LinkedHashSet<Node> setByFeq = freToNode.get(feq);

        setByFeq.remove(node);
        int newFeq = 1+feq;
        //判断原频次是否最小频次 同时 该集合在移除这个node之后空了，如果是的话，就要更新min为当前加1
        if(setByFeq.isEmpty() && feq == min){
            min = newFeq;
        }
        //将node加入新的频次集合
        node.addFrequent();
        LinkedHashSet<Node> newFreqSet = freToNode.get(newFeq);
        if(newFreqSet == null){
            newFreqSet = new LinkedHashSet();
        }
        newFreqSet.add(node);
        freToNode.put(newFeq, newFreqSet);
    }



    public Node evictMinNode(){
        if(min == 0){
            return null;
        }
        LinkedHashSet<Node> minNode = freToNode.get(min);
        if(minNode == null || minNode.isEmpty()){
            return null;
        }
        Node evict = minNode.iterator().next();
        minNode.remove(evict);
        if(minNode.isEmpty()){ //这里需要更新min
            // min = freToNode.
        }
        freToNode.put(min, minNode);
        return evict;
    }


    public Node addNode(int key,int value){
       
        Node node = new Node(key,value);
        LinkedHashSet<Node> minNodes = freToNode.get(node.frequent);
        if(minNodes == null){
            minNodes = new LinkedHashSet();
        }
        minNodes.add(node);
        freToNode.put(1, minNodes);
        min = 1;
        return node;
    }
}






class Node{

    public int key;

    public int value;

    public int frequent;


    public Node(int key,int value){
        this.key = key;
        this.value = value;
        this.frequent = 1;
    }


    public void addFrequent(){
        this.frequent++;
    }


    public void decFrequent(){
        this.frequent--;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
