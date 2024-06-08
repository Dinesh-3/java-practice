package com.dinesh.algorithm.graph;

import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0,1}};

        CourseSchedule2 schedule2 = new CourseSchedule2();
        schedule2.findOrder(numCourses, prerequisites);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++)
            adList.add(new ArrayList<>());

        for(var row: prerequisites) {
            adList.get(row[0]).add(row[1]);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new Stack<>();

        for (int i = numCourses - 1; i >= 0; i--) {
            if(visited.contains(i))
                continue;
            if(dfs(i, adList,visiting, visited, result))
                return new int[0];
        }


        int[] dp = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            dp[i] = result.get(i);

        return dp;
    }

    private boolean dfs(int course, List<List<Integer>> adList, Set<Integer> visiting, Set<Integer> visited, List<Integer> result) {
        visiting.add(course);

        for(var ad: adList.get(course)) {
                if(visited.contains(ad))
                    continue;
            if(visiting.contains(ad))
            {
                return true;
            }else {
                if(dfs(ad, adList, visiting, visited, result))
                    return true;
            }
        }


        visited.add(course);
        result.add(course);
        return false;
    }

}
