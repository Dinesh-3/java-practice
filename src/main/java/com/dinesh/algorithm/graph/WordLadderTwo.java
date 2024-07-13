package com.dinesh.algorithm.graph;

import java.util.*;

public class WordLadderTwo {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot","dot","dog","lot","log","cog");

        WordLadderTwo ladder = new WordLadderTwo();
        ladder.findLadders(beginWord, endWord, wordList);
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Queue<List<String>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(List.of(beginWord)));

        List<List<String>> result = new ArrayList<>();

        Set<String> wordsSet = new HashSet<>(wordList);

        while( !queue.isEmpty() ) {

            Set<String> takens = new HashSet<>();

            int length = queue.size();

            for (int n = 0; n < length; n++) {
                List<String> words = queue.remove();
                String last = words.get(words.size() - 1);
                if(last.equals(endWord)) {
                    if(result.isEmpty() || result.get(0).size() == words.size()) {
                        result.add(words);
                    } else {
                        break;
                    }
                }

                for(int i = 0; i < last.length(); i++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        char[] chars = last.toCharArray();
                        chars[i] = c;
                        String newWord = new String(chars);
                        if(wordsSet.contains(newWord)) {
                            List<String> ladders = new ArrayList<>(words);
                            ladders.add(newWord);
                            takens.add(newWord);
                            queue.add(ladders);
                        }
                    }
                }

            }

            wordsSet.removeAll(takens);
        }

        return result;
    }

    public List<List<String>> findLaddersS(String beginWord, String endWord, List<String> wordList) {

        Set < String > st = new HashSet < String > ();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }

        // Creating a queue ds which stores the words in a sequence which is
        // required to reach the targetWord after successive transformations.
        Queue < ArrayList < String >> q = new LinkedList < > ();
        ArrayList <String> ls = new ArrayList < > ();
        ls.add(beginWord);
        q.add(ls);
        ArrayList < String > usedOnLevel = new ArrayList < > ();
        usedOnLevel.add(beginWord);
        int level = 0;

        // A vector to store the resultant transformation sequence.
        List < List < String >> ans = new ArrayList < > ();
        int cnt = 0;

        // BFS traversal with pushing the new formed sequence in queue
        // when after a transformation, a word is found in wordList.
        while (!q.isEmpty()) {
            cnt++;
            ArrayList < String > vec = q.peek();
            q.remove();

            // Now, erase all words that have been
            // used in the previous levels to transform
            if (vec.size() > level) {
                level++;
                for (String it: usedOnLevel) {
                    st.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

            // store the answers if the end word matches with targetWord.
            if (word.equals(endWord)) {
                // the first sequence where we reached the end.
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }
            for (int i = 0; i < word.length(); i++) {

                // Now, replace each character of ‘word’ with char
                // from a-z then check if ‘word’ exists in wordList.
                for (char c = 'a'; c <= 'z'; c++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord) == true) {
                        vec.add(replacedWord);
                        // Java works by reference, so enter the copy of vec
                        // otherwise if you remove word from vec in next lines, it will
                        // remove from everywhere
                        ArrayList < String > temp = new ArrayList < > (vec);
                        q.add(temp);
                        // mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }

            }
        }
        return ans;


    }

}
