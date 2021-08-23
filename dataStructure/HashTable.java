package dataStructure;

import java.util.LinkedList;

public class HashTable {
    private class Node{
        private int key;
        private String value;
        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] hashTable = new LinkedList[5];

    public void put(int key, String value) {
        var item = getNode(key);
        if(item != null) {
            item.value = value;
            return;
        }

        var bucket = getOrCreateBucket(key);
        bucket.add(new Node(key, value));

    }

    public String get(int key){
        var item = getNode(key);
        return item == null ? null : item.value;
    }

    public void remove(int key){
        var bucket = getBucket(key);
        if(bucket != null)
            bucket.removeIf(item -> item.key == key);
    }

    private LinkedList<Node> getOrCreateBucket(int key){

        var index = getIndex(key);

        if(hashTable[index] == null)
            hashTable[index] = new LinkedList<>();

        return hashTable[index];
    }

    private LinkedList<Node> getBucket(int key){
        return hashTable[getIndex(key)];
    }

    private Node getNode(int key){
        var bucket = getBucket(key);
        if(bucket != null) {
            for(var item: bucket)
                if(item.key == key) return item;
        }
        return null;
    }
    private int getIndex(int key) {
        return key % hashTable.length;
    }

}
