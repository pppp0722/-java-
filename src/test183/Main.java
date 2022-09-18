package test183;
// 백준/골드3/11779 최소비용 구하기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점, 간선 수 입력
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 그래프 선언 및 초기화
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 입력
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            graph.get(from).add(new Node(to, w));
        }

        // 출발, 도착 정점 입력
        String[] line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);

        // 거리 초기화
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 경로 초기화
        ArrayList<ArrayList<Integer>> path = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            path.add(new ArrayList<>());
        }

        // 출발 정점 설정
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        path.get(start).add(start);

        // 우선순위 큐 다익스트라
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // 이미 더 빠른 경로로 방문했으면 continue
            if (dist[node.v] < node.w) {
                continue;
            }

            // 현재 정점의 모든 간선들에 대해
            for (Node nextNode : graph.get(node.v)) {
                int cost = dist[node.v] + nextNode.w;

                // 현재 정점을 통한 경로가 더 빠르면 갱신
                if (cost < dist[nextNode.v]) {
                    dist[nextNode.v] = cost;
                    pq.offer(new Node(nextNode.v, dist[nextNode.v]));
                    ArrayList<Integer> nextPath = path.get(nextNode.v);

                    // 경로 재설정
                    nextPath.clear();
                    nextPath.addAll(path.get(node.v));
                    nextPath.add(nextNode.v);
                }
            }
        }

        System.out.println(dist[end]);
        System.out.println(path.get(end).size());
        for (int v : path.get(end)) {
            System.out.print(v + " ");
        }
    }
}

class Node implements Comparable<Node> {

    public int v;
    public int w;

    public Node(int to, int w) {
        this.v = to;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}