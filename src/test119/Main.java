package test119;
// 백준/골드4/1753 최단경로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        int start = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            graph.get(from).add(new Edge(to, cost));

        }

        boolean[] visited = new boolean[V + 1];
        int[] dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        for (int i = 0; i < V; i++) {
            int idx = 0;
            int cost = Integer.MAX_VALUE;
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && dist[j] < cost) {
                    cost = dist[j];
                    idx = j;
                }
            }

            visited[idx] = true;

            List<Edge> edges = graph.get(idx);
            for (int j = 0; j < edges.size(); j++) {
                Edge edge = edges.get(j);
                dist[edge.to] = Math.min(cost + edge.cost, dist[edge.to]);
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}

class Edge {

    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
