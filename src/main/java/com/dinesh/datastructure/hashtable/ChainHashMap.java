package com.dinesh.datastructure.hashtable;

import java.util.LinkedList;
import java.util.List;

public class ChainHashMap {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table = new LinkedList[16];

    public void put(int key, String value){
        int index = getHashKey(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>(List.of(new Entry(key, value)));
        } else {
            for (Entry entry : table[index]) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }
            table[index].add(new Entry(key, value));
        }
    }

    public String get(int key) {
        int index = getHashKey(key);

        LinkedList<Entry> linkedList = table[index];

        if(linkedList == null)
            return null;

        for (Entry entry : linkedList) {
            if(entry.key == key)
                return entry.value;
        }
        return null;
    }

    private int getHashKey(int key) {
        return key % table.length;
    }

    public void remove(int key) {
        int index = getHashKey(key);
        LinkedList<Entry> bucket = table[index];

        if(bucket == null)
            return;

        bucket.removeIf(entry -> entry.key == key);

    }
}
