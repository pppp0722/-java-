package test122;
// 백준/골드4/1197 최소 스패닝 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        int E = Integer.parseInt(line[1]);
        for (int i = 0; i < E; i++) {
            line = br.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            graph.get(v1).add(new Edge(v2, cost));
            graph.get(v2).add(new Edge(v1, cost));
        }

        int ct = 0;
        int result = 0;
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited[edge.to]) {
                continue;
            }

            visited[edge.to] = true;
            result += edge.cost;

            for (Edge nextEdge : graph.get(edge.to)) {
                if (!visited[nextEdge.to]) {
                    pq.offer(nextEdge);
                }
            }

            if (++ct == V) {
                break;
            }
        }

        System.out.println(result);
    }
}

class Edge implements Comparable<Edge> {

    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
