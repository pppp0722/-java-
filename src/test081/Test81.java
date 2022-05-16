package test081;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스/Level3/가장 먼 노드
public class Test81 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int result = solution.solution(n, edge);
        System.out.println(result);
    }
}

class Solution {

    static int[][] edges;
    static int[] paths;
    static boolean[] visited;
    static int answer = 0;
    static int maxPath = 0;

    public int solution(int n, int[][] edge) {
        edges = edge;
        paths = new int[n];
        visited = new boolean[n];

        bfs();

        return answer;
    }

    public void bfs() {
        Queue<Integer> queue = new LinkedList();
        visited[0] = true;
        queue.add(1);
        while (!queue.isEmpty()) {
            int startVertex = queue.remove();
            for (int i = 0; i < edges.length; i++) {
                int nextVertex;
                if (edges[i][0] == startVertex) {
                    nextVertex = edges[i][1];
                } else if (edges[i][1] == startVertex) {
                    nextVertex = edges[i][0];
                } else {
                    continue;
                }

                if (visited[nextVertex - 1]) {
                    continue;
                }

                int nextPath = paths[startVertex - 1] + 1;
                paths[nextVertex - 1] = nextPath;
                if (nextPath > maxPath) {
                    maxPath = nextPath;
                    answer = 1;
                } else if (nextPath == maxPath) {
                    answer++;
                }
                visited[nextVertex - 1] = true;
                queue.add(nextVertex);
            }
        }
    }
}