package test071;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// 프로그래머스/Level2/프린터
public class Test71 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int result = solution.solution(priorities, location);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            map.put(i, priorities[i]);
            queue.add(i);
        }

        int answer = 1;
        while(true) {
            int front = queue.poll();
            int frontPriority = map.get(front);

            if(isHighestPrioriy(map, frontPriority)) {
                if(front == location) break;
                map.remove(front);
                answer++;
            } else {
                queue.add(front);
            }
        }

        return answer;
    }

    public boolean isHighestPrioriy(Map<Integer, Integer> map, int priority) {
        boolean ret = true;
        if (map.values().stream()
                .filter(v -> v > priority)
                .count() > 0) {
            ret = false;
        }

        return ret;
    }
}