package test202;
// 완탐/백준/실버2/1260 DFS와 BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int v = Integer.parseInt(line[2]);

        boolean[][] adj = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);
            adj[v1][v2] = true;
            adj[v2][v1] = true;
        }

        StringBuilder dfsPath = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] dfsVisited = new boolean[n + 1];
        stack.push(v);

        while (!stack.isEmpty()) {
            int cv = stack.pop();

            if (dfsVisited[cv]) {
                continue;
            }

            dfsVisited[cv] = true;
            dfsPath.append(cv).append(" ");

            for (int nv = n; nv >= 1; nv--) {
                if (!adj[cv][nv] || dfsVisited[nv]) {
                    continue;
                }

                stack.push(nv);
            }
        }

        StringBuilder bfsPath = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        boolean[] bfsVisited = new boolean[n + 1];
        q.offer(v);
        bfsVisited[v] = true;

        while (!q.isEmpty()) {
            int cv = q.poll();
            bfsPath.append(cv).append(" ");

            for (int nv = 1; nv <= n; nv++) {
                if (!adj[cv][nv] || bfsVisited[nv]) {
                    continue;
                }

                q.offer(nv);
                bfsVisited[nv] = true;
            }
        }

        System.out.println(dfsPath);
        System.out.println(bfsPath);
    }
}
