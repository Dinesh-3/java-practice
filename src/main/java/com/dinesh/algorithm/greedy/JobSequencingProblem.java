package com.dinesh.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * Job sequencing Problem
 * https://www.youtube.com/watch?v=LjPx4wQaRIs
 *
 */
public class JobSequencingProblem {
    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {new Job(1,4,20),new Job(2,1,10),new Job(3,1,40),new Job(4,1,30)};
        JobSequencingProblem problem = new JobSequencingProblem();
        int[] profits = problem.JobScheduling(jobs, jobs.length);
        System.out.println("profits = " + Arrays.toString(profits));
    }

    int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o2.profit, o1.profit));

        int maxDeadline = 0;
        for(var job: arr)
            maxDeadline = Math.max(job.deadline, maxDeadline);

        int[] days = new int[maxDeadline];

        int jobs = 0;
        int profit = 0;
        for(int i = 0; i < arr.length; i++) {
            int emptySlot = arr[i].deadline - 1;
            while(emptySlot >= 0 && days[emptySlot] != 0)
                emptySlot--;

            if(emptySlot >= 0) {
                days[emptySlot] = arr[i].profit;
                jobs++;
                profit += arr[i].profit;
            }

        }

        return new int[] { jobs, profit };

    }

}
