package test227;
// 다익/백준/골드2/17835 면접보는 승범이네

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<List<Node>> graph = new ArrayList<>();
        Set<Integer> companies = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            graph.get(v).add(new Node(u, c)); // 면접장부터 시작하기 위해 역방향 입력
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            companies.add(Integer.parseInt(st.nextToken()));
        }

        // 다익스트라
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int start : companies) {
            pq.offer(new Node(start, 0L));
            dist[start] = 0L;
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.w > dist[node.v]) {
                continue;
            }

            for (Node nextNode : graph.get(node.v)) {
                long nextDist = dist[node.v] + nextNode.w;
                if (nextDist < dist[nextNode.v]) {
                    dist[nextNode.v] = nextDist;
                    pq.offer(new Node(nextNode.v, nextDist));
                }
            }
        }

        // 최대 거리 구하기
        List<Node> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!companies.contains(i)) {
                list.add(new Node(i, dist[i]));
            }
        }
        Collections.sort(list, (o1, o2) -> Long.compare(o2.w, o1.w));
        Node maxNode = list.get(0);

        System.out.println(maxNode.v);
        System.out.println(maxNode.w);
    }
}

class Node implements Comparable<Node> {

    public int v;
    public long w;

    public Node(int v, long w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(w, o.w);
    }
}