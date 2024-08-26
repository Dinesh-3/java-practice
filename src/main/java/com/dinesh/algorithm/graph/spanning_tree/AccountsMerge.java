package com.dinesh.algorithm.graph.spanning_tree;

import java.util.*;

/**
 *
 * 721. Accounts Merge
 * https://leetcode.com/problems/accounts-merge/
 *
 * https://takeuforward.org/data-structure/accounts-merge-dsu-g-50/
 * https://www.youtube.com/watch?v=FMwpt_aQOGw
 *
 */
public class AccountsMerge {
    public class DisjointSet {
        int[] size;
        int[] parent;
        public DisjointSet(int len) {
            this.size = new int[len];
            int[] init = new int[len];
            for(int i = 0; i < len; i++)
                init[i] = i;
            this.parent = init;
        }

        public int getParent(int index) {
            if(parent[index] == index)
                return index;
            int root = getParent(parent[index]);
            parent[index] = root;
            return root;
        }

        public void unionBySize(int x, int y) {
            int parentX = getParent(x);
            int parentY = getParent(y);
            if(size[parentX] > size[parentY]) {
                parent[parentY] = parent[parentX];
                size[parentX] += size[parentY];
            } else {
                parent[parentX] = parent[parentY];
                size[parentY] += size[parentX];
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();

        DisjointSet set = new DisjointSet(accounts.size());

        for(int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for(int mailIndex = 1; mailIndex < account.size(); mailIndex++) {
                String email = account.get(mailIndex);
                if(map.containsKey(email))
                    set.unionBySize(map.get(email), i);
                else
                    map.put(email, i);
            }
        }

        Map<Integer, SortedSet<String>> sortedMap = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++) {
            int rootParent = set.getParent(i);
            sortedMap.computeIfAbsent(rootParent, (e) -> new TreeSet<>())
                    .addAll(accounts.get(i).subList(1, accounts.get(i).size()));
        }

        List<List<String>> result = new ArrayList<>();

        for(var entry: sortedMap.entrySet()) {
            List<String> account = new ArrayList<>();
            account.add(accounts.get(entry.getKey()).get(0));
            account.addAll(entry.getValue());
            result.add(account);
        }

        return result;

    }

}
