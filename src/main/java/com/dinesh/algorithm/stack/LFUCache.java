package com.dinesh.algorithm.stack;

import java.util.*;

/**
 *
 * 460. LFU Cache
 * https://leetcode.com/problems/lfu-cache/
 *
 * https://www.youtube.com/watch?v=0PSB9y8ehbk
 *
 */
public class LFUCache {
    class Node {
        int key;
        int value;
        int freq;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    SortedMap<Integer, Deque<Node>> treeMap = new TreeMap<>();
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            changeFrequency(key);
            return map.get(key).value;
        }
        return -1;
    }

    private void changeFrequency(int key) {
        Node node = map.get(key);
        Deque<Node> queue = treeMap.get(node.freq);
        queue.remove(node);
        if(queue.isEmpty())
            treeMap.remove(node.freq);

        node.freq += 1;
        treeMap.computeIfAbsent(node.freq, (e) -> new LinkedList<>())
                .addFirst(node);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            changeFrequency(key);
            Node node = map.get(key);
            node.value = value;
            return;
        }
        if(map.size() >= capacity)
            clearCache();

        Node node = new Node(key, value);
        treeMap.computeIfAbsent(1, (e) -> new LinkedList<>())
                .addFirst(node);
        map.put(key, node);
    }

    private void clearCache() {
        Integer firstKey = treeMap.firstKey();
        Deque<Node> nodes = treeMap.get(firstKey);
        Node removed = nodes.removeLast();
        if(nodes.isEmpty())
            treeMap.remove(firstKey);
        map.remove(removed.key);
    }


}
