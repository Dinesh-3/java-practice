import java.util.* ;
import java.io.*;

class Solution {

    static class Node {
        char val;
        Node[] children = new Node[26];
        boolean isEnd;
        public Node(char val) {
            this.val = val;
        }
    }

    public static String completeString(int n, String[] a) {
        Arrays.sort(a, (f,b) -> b.length() - f.length());
        Node root = new Node('-');

        for(String word: a) {
            Node current = root;

            for(char ch: word.toCharArray()) {
                if(current.children[ch-'a'] == null)
                    current.children[ch-'a'] = new Node(ch);
                current = current.children[ch-'a'];
            }

            current.isEnd = true;
        }

        for(String word: a) {
            Node current = root;
            boolean isValid = true;
            for(char ch: word.toCharArray()) {
                if(current.children[ch-'a'] == null || !current.children[ch-'a'].isEnd) {
                    isValid = false;
                    break;
                }
                current = current.children[ch-'a'];
            }
            if(isValid && current.isEnd)
                return word;
        }

        return "None";

    }
}