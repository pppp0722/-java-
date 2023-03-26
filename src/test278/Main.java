package test278;
// 다익/백준/골드5/5972 택배 배송

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // O(E) -> 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Node(v2, w));
            graph.get(v2).add(new Node(v1, w));
        }

        // O(ElogV) - 다익스트라
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2.w));
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.w > dist[cur.v]) {
                continue;
            }

            for (Node next : graph.get(cur.v)) {
                int nextW = cur.w + next.w;
                if (nextW < dist[next.v]) {
                    dist[next.v] = nextW;
                    pq.offer(new Node(next.v, nextW));
                }
            }
        }

        System.out.println(dist[n]);
    }
}

class Node {

    public int v;
    public int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}