package test071;
// 큐/프로그래머스/Level2/프린터

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
            pq.offer(priorities[i]);
        }

        int order = 1;
        while (true) {
            int[] cur = q.poll();
            if (cur[1] != pq.peek()) {
                q.offer(cur);
            } else {
                if (cur[0] == location) {
                    break;
                }
                pq.poll();
                order++;
            }
        }
        return order;
    }
}