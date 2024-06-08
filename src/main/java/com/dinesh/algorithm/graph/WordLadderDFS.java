package com.dinesh.algorithm.graph;

import java.util.*;

public class WordLadderDFS {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";

        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");

        WordLadderDFS ladderDFS = new WordLadderDFS();
        ladderDFS.ladderLength(beginWord, endWord, wordList);
    }

    public class Node {
        private String value;
        private int level;
        public Node(String value, int level) {
            this.value = value;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, 1));

        while(!queue.isEmpty()) {
            Node node = queue.remove();

            for(int i = 0; i < node.value.length(); i++) {
                for(int let = 0; let < 26; let++) {
                    String newWord = node.value.substring(0, i) + (char) (97 + let) + node.value.substring(i+1);
                    if(set.contains(newWord) && newWord.equals(endWord))
                        return node.level + 1;
                    if(set.contains(newWord)) {
                        queue.add(new Node(newWord, node.level + 1));
                        set.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }
}
