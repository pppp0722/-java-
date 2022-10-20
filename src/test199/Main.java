package test199;
// 백준/골드4/1504 특정한 최단 경로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static int n;
    public static List<List<Edge>> map;

    public static void main(String[] args) throws IOException {
        map = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        int e = Integer.parseInt(line[1]);
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            line = br.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            map.get(v1).add(new Edge(v2, w));
            map.get(v2).add(new Edge(v1, w));
        }
        line = br.readLine().split(" ");
        int v1 = Integer.parseInt(line[0]);
        int v2 = Integer.parseInt(line[1]);

        int oneToV1 = dijkstra(1, v1);
        int v1ToN = dijkstra(v1, n);
        int oneToV2 = dijkstra(1, v2);
        int v2ToN = dijkstra(v2, n);

        System.out.println(getAnswer(oneToV1, v1ToN, oneToV2, v2ToN));
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (dist[edge.v] < edge.w) {
                continue;
            }

            for (Edge nextEdge : map.get(edge.v)) {
                int w = dist[edge.v] + nextEdge.w;

                if (w < dist[nextEdge.v]) {
                    dist[nextEdge.v] = w;
                    pq.offer(new Edge(nextEdge.v, w));
                }
            }
        }

        return dist[end];
    }

    public static int getAnswer(int oneToV1, int v1ToN, int oneToV2, int v2ToN) {
        int dist1;
        if (oneToV1 == Integer.MAX_VALUE || v1ToN == Integer.MAX_VALUE) {
            dist1 = Integer.MAX_VALUE;
        } else {
            dist1 = oneToV1 + v1ToN;
        }

        int dist2;
        if (oneToV2 == Integer.MAX_VALUE || v2ToN == Integer.MAX_VALUE) {
            dist2 = Integer.MAX_VALUE;
        } else {
            dist2 = oneToV2 + v2ToN;
        }

        return dist1 == Integer.MAX_VALUE && dist2 == Integer.MAX_VALUE ? -1
            : Math.min(dist1, dist2);
    }
}

class Edge implements Comparable<Edge> {

    public int v;
    public int w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return w - o.w;
    }
}
