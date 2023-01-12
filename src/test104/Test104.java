package test104;
// BFS/프로그래머스/Level4/동굴 탐험

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    private int size;
    private List<List<Integer>> graph;
    private int[] before;
    private int[] after;

    public boolean solution(int n, int[][] path, int[][] order) {
        init(n, path, order);
        return canSearchAllRooms();
    }

    private void init(int n, int[][] path, int[][] order) {
        size = n;
        graph = new ArrayList<>();
        before = new int[n];
        after = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] arr : path) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        for (int[] arr : order) {
            before[arr[1]] = arr[0];
            after[arr[0]] = arr[1];
        }
    }

    private boolean canSearchAllRooms() {
        int numOfRoomsVisited = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[size]; // 0 : 방문 X, 1 : 방문 but 선후관계 X, 2 : 방문
        if (before[0] == 0) {
            q.offer(0);
            visited[0] = 2;
        }
        while (!q.isEmpty()) {
            int curNode = q.poll();
            numOfRoomsVisited++;
            for (int nextNode : graph.get(curNode)) {
                if (visited[nextNode] == 2) {
                    continue;
                }
                if (visited[before[nextNode]] != 2) {
                    visited[nextNode] = 1;
                    continue;
                }
                q.offer(nextNode);
                visited[nextNode] = 2;
            }
            int saveNode = after[curNode];
            if (saveNode != 0 && visited[saveNode] == 1) {
                q.offer(saveNode);
                visited[saveNode] = 2;
            }
        }
        return numOfRoomsVisited == size;
    }
}