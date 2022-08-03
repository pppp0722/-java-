package test154;
// 백준/골드3/1238 파티

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static int M;
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        X = Integer.parseInt(line[2]);
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            graph.get(from).add(new Edge(to, cost));
        }

        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            int[] curDist = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                curDist[j] = Integer.MAX_VALUE;
            }
            curDist[i] = 0;

            for (int j = 1; j <= N; j++) {
                int idx = 0;
                int cost = Integer.MAX_VALUE;
                for (int k = 1; k <= N; k++) {
                    if (!visited[k] && curDist[k] < cost) {
                        cost = curDist[k];
                        idx = k;
                    }
                }

                visited[idx] = true;

                for (Edge edge : graph.get(idx)) {
                    curDist[edge.getTo()] = Math.min(cost + edge.getCost(), curDist[edge.getTo()]);
                }
            }

            dist[i] = curDist;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(dist[i][X] + dist[X][i], answer);
        }

        System.out.println(answer);
    }
}

class Edge {

    private int to;
    private int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    public int getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
}
