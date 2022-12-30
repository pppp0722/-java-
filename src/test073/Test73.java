package test073;
// 그리디/프로그래머스/Level3/디스크 컨트롤러

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        PriorityQueue<int[]> pq2 = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] job : jobs) {
            pq1.offer(job);
        }

        int time = pq1.peek()[0];
        int totalTime = 0;
        while (!pq1.isEmpty() || !pq2.isEmpty()) {
            int[] cur;
            if (pq2.isEmpty()) {
                cur = pq1.poll();
                time = cur[0];
            } else {
                cur = pq2.poll();
            }
            time += cur[1];
            totalTime += time - cur[0];
            while (!pq1.isEmpty() && pq1.peek()[0] <= time) {
                pq2.offer(pq1.poll());
            }
        }

        return totalTime / jobs.length;
    }
}