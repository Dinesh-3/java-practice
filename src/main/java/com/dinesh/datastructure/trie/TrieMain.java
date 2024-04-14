package com.dinesh.datastructure.trie;

import java.util.List;

public class TrieMain {
    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.add("bag");
        trie.add("base");
        trie.add("boys");
        trie.add("boy");
        trie.add("apple");

        trie.remove("boys");
        System.out.println("trie.contains(\"boys\") = " + trie.contains("boys"));

        System.out.println("=== PREORDER TRAVERSAL START ===");
        trie.preOrderTraversal();
        System.out.println("=== PREORDER TRAVERSAL END ===");

//        trie.remove("boys");
        System.out.println(trie.findWords("ba"));
        System.out.println(trie.countWords());

        String prefix =  Trie.longestCommonPrefix(List.of("car", "c", "car"));
        System.out.println(prefix);
    }
}
