package test180;
// 프로그래머스/Level3/등산코스 정하기

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        Set<Integer> gateSet = new HashSet<>();
        for (int gate : gates) {
            gateSet.add(gate);
        }
        Set<Integer> summitSet = new HashSet();
        for (int summit : summits) {
            summitSet.add(summit);
        }
        for (int[] path : paths) {
            if (!gateSet.contains(path[1]) && !summitSet.contains(path[0])) {
                map.get(path[0]).add(new Edge(path[1], path[2]));
            }
            if (!gateSet.contains(path[0]) && !summitSet.contains(path[1])) {
                map.get(path[1]).add(new Edge(path[0], path[2]));
            }
        }

        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        boolean[] visited = new boolean[n + 1];
        int[] intensity = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            intensity[i] = Integer.MAX_VALUE - 1;
        }
        for (int gate : gates) {
            intensity[gate] = 0;
        }
        for (int i = 0; i < n; i++) {
            int idx = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && intensity[j] < min) {
                    min = intensity[j];
                    idx = j;
                }
            }

            visited[idx] = true;

            for (Edge edge : map.get(idx)) {
                if (intensity[edge.to] > Math.max(intensity[idx], edge.w)) {
                    intensity[edge.to] = Math.max(intensity[idx], edge.w);
                }
            }
        }
        for (int summit : summits) {
            if (intensity[summit] == answer[1]) {
                answer[0] = Math.min(summit, answer[0]);
            } else if (intensity[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = intensity[summit];
            }
        }

        return answer;
    }
}

class Edge {

    public int to;
    public int w;

    public Edge(int to, int w) {
        this.to = to;
        this.w = w;
    }
}

public class Test180 {

    public static void main(String[] args) {
        int n = 7;
        int[][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1},
            {6, 7, 1}};
        int[] gates = {3, 7};
        int[] summits = {1, 5};
        int[] answer = new Solution().solution(n, paths, gates, summits);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}