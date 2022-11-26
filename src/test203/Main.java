package test203;
// MST/백준/골드2/1368 물대기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ws = new int[n + 1];
        parents = new int[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int answer = 0;

        // 우물 파는 비용과 서로소 배열 초기화
        for (int i = 1; i <= n; i++) {
            ws[i] = Integer.parseInt(br.readLine());
            parents[i] = i;
        }

        // 크루스칼 위해 pq에 간선 초기화, 우물 파는 경우 가상의 노드와 연결
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int w = Integer.parseInt(line[j - 1]);
                if (i == j) {
                    pq.add(new Edge(0, i, ws[i]));
                } else if (i < j) {
                    pq.add(new Edge(i, j, w));
                }
            }
        }

        // 크루스칼
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (find(edge.v1) == find(edge.v2)) {
                continue;
            }

            union(edge.v1, edge.v2);
            answer += edge.w;
        }

        System.out.println(answer);
    }

    private static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 > p2) {
            parents[p1] = p2;
        } else {
            parents[p2] = p1;
        }
    }

    private static int find(int v) {
        if (parents[v] == v) {
            return v;
        } else {
            return find(parents[v]);
        }
    }
}

class Edge implements Comparable<Edge> {

    int v1;
    int v2;
    int w;

    public Edge(int v1, int v2, int w) {
        this.v1 = v1;
        this.v2 = v2;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return w - o.w;
    }
}