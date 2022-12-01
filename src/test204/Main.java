package test204;
// 다익/백준/골드5/1916 최소비용 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();
        String[] line;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            graph.get(s).add(new Node(e, w));
        }
        line = br.readLine().split(" ");
        int startCity = Integer.parseInt(line[0]);
        int endCity = Integer.parseInt(line[1]);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[startCity] = 0;
        pq.offer(new Node(startCity, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.w > dist[node.v]) {
                continue;
            }

            for (Node nextNode : graph.get(node.v)) {
                int nextDist = dist[node.v] + nextNode.w;
                if (nextDist < dist[nextNode.v]) {
                    dist[nextNode.v] = nextDist;
                    pq.offer(new Node(nextNode.v, nextDist));
                }
            }
        }

        System.out.println(dist[endCity]);
    }
}

class Node implements Comparable<Node> {

    int v;
    int w;

    public Node(int s, int w) {
        this.v = s;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return w - o.w;
    }
}