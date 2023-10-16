package com.dinesh.datastructure.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private class Node {
            private char value;

//            private char[] childrens = new char[26];
            private Map<Character, Node> children = new HashMap<>();
            private boolean isWordEnd = false;

            private Node(char value) {
                this.value = value;
            }

            public boolean hasChild(char character) {
                return children.containsKey(character);
            }

            public boolean hasChildren() {
                return children.values().size() > 0;
            }

            public void addChild(char character) {
                children.put(character, new Node(character));
            }

            public Node getChild(char character) {
                return children.get(character);
            }

            public void removeChild(char character) {
                children.remove(character);
            }

            public Node[] getChildren() {
                return children.values().toArray(new Node[0]);
            }
        }

        private Node root = new Node('-');

        public void add(String word) {
            char[] array = word.toLowerCase().toCharArray();

            Node current = root;

            for (var character: array) {
//                int index = character - 'a';
//                if(current.children[index] == null) {
//                    current.children[index] = new Node(character);
//                }
//                current = current.children[index];
                if(!current.hasChild(character))
                    current.addChild(character);
                current = current.getChild(character);
            }

            current.isWordEnd = true;

        }

        public boolean contains(String word) {
            if(word == null) return false;

            char[] chars = word.toLowerCase().toCharArray();

            Node current = root;
            for (var character: chars) {
                if(!current.hasChild(character))
                    return false;
                current = current.getChild(character);
            }

            return current.isWordEnd;

        }

        public void remove(String word){
            remove(root, word, 0);
        }

    private void remove(Node current, String word, int index) {
        if(index == word.length()) {
            current.isWordEnd = false;
            return;
        }

        char character = word.charAt(index);

        var child = current.getChild(character);

        if(child == null)
            return;

        remove(child, word, index + 1);

        if(!child.isWordEnd && !child.hasChildren())
            current.removeChild(word.charAt(index));

    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();

        if(prefix == null)
            return words;

        Node lastNode = findLastNodeOf(prefix);
        traverse(lastNode, words, new StringBuilder(prefix));

        return words;
    }

    private Node findLastNodeOf(String prefix) {

        char[] array = prefix.toLowerCase().toCharArray();

        Node current = root;
        for (var character: array) {
            if(!current.hasChild(character))
                return null;
            current = current.getChild(character);
        }

        return current;
    }

    private void traverse(Node current, List<String> words, StringBuilder word) {
        if(current == null)
            return;

        if(current.isWordEnd)
            words.add(word.toString());

        for (var node: current.getChildren()) {
            var character = node.value;
            traverse(current.getChild(character), words, word.append(character));
        }

        if(word.length() > 0)
            word.deleteCharAt(word.length() - 1);

    }

    public int countWords() {
        List<String> words = new ArrayList<>();
        traverse(root, words, new StringBuilder());

        return words.size();
    }

    public static String longestCommonPrefix(List<String> words) {
        String first = words.get(0);

        for (int i = 0; i < first.length(); i++) {
            for (String word : words) {
                if (!(word.length() > i && word.charAt(i) == first.charAt(i)))
                    return first.substring(0, i);
            }
        }

        return first;

    }

    public static String longestCommonPrefixWithTrie(String[] words) {
            Trie trie = new Trie();

        for (var word: words) {
            trie.add(word);
        }

        String minWord = getMinLengthWord(words);

        StringBuilder prefix = new StringBuilder();

        Node current = trie.root;
        while (prefix.length() < minWord.length()) {
            Node[] children = current.getChildren();
            if(children.length != 1)
                break;
            current = children[0];
            prefix.append(current.value);
        }

        return prefix.toString();
    }

    private static String getMinLengthWord(String[] words) {
        if (words == null || words.length == 0)
            return "";

        var shortest = words[0];
        for (var i = 1; i < words.length; i++) {
            if (words[i].length() < shortest.length())
                shortest = words[i];
        }

        return shortest;
    }

}


