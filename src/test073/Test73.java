package test073;

import java.util.Arrays;
import java.util.PriorityQueue;

// 프로그래머스/Level3/디스크 컨트롤러
// 힙
public class Test73 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = {{0, 6}, {2, 8}, {3, 7}, {7, 1}, {11, 11}, {19, 25}, {30, 15}, {32, 6}, {40, 3}};
        int result = solution.solution(jobs);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int indexOfJobs = 0;
        int endTime = 0;
        int totalTime = 0;
        int numberOfCompletedJobs = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while (numberOfCompletedJobs < jobs.length) {
            while (indexOfJobs < jobs.length && jobs[indexOfJobs][0] <= endTime) {
                pq.add(jobs[indexOfJobs++]);
            }

            if (pq.isEmpty()) {
                endTime = jobs[indexOfJobs][0];
            } else {
                int[] job = pq.poll();
                totalTime += endTime + job[1] - job[0];
                endTime += job[1];
                numberOfCompletedJobs++;
            }
        }

        return totalTime / jobs.length;
    }
}