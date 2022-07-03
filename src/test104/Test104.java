package test104;
// 프로그래머스/Level4/동굴 탐험
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

    Map<Integer, List<Integer>> map;
    boolean[] visited;
    int[] before;
    int[] save;

    public boolean solution(int n, int[][] path, int[][] order) {
        map = new HashMap<>();
        visited = new boolean[n];
        before = new int[n];
        save = new int[n];

        for (int[] a : path) {
            List<Integer> list1 = map.getOrDefault(a[0], new ArrayList<>());
            list1.add(a[1]);
            map.put(a[0], list1);

            List<Integer> list2 = map.getOrDefault(a[1], new ArrayList<>());
            list2.add(a[0]);
            map.put(a[1], list2);
        }

        for (int[] a : order) {
            before[a[1]] = a[0];
        }

        if (before[0] != 0) {
            return false;
        }

        bfs();

        return getResult();
    }

    void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (Integer i : map.get(0)) {
            q.offer(i);
        }
        visited[0] = true;
        while (!q.isEmpty()) {
            int n = q.poll();

            if (visited[n]) {
                continue;
            }

            if (!visited[before[n]]) {
                save[before[n]] = n;
                continue;
            }

            visited[n] = true;
            for (Integer i : map.get(n)) {
                q.offer(i);
            }
            if (save[n] != 0) {
                q.offer(save[n]);
            }
        }
    }

    boolean getResult() {
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
    }
}

public class Test104 {

    public static void main(String[] args) {
        int n = 9;
        int[][] path = {{0, 1}, {0, 3}, {0, 7}, {8, 1}, {3, 6}, {1, 2}, {4, 7}, {7, 5}};
        int[][] order = {{8, 5}, {6, 7}, {4, 1}};
        boolean result = new Solution().solution(n, path, order);
        System.out.println(result);
    }
}