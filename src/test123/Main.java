package test123;
// 백준/골드4/1647 도시 분할 계획

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        parent = new int[V + 1];
        List<Edge> list = new ArrayList<>();
        int E = Integer.parseInt(line[1]);
        for (int i = 0; i < E; i++) {
            line = br.readLine().split(" ");
            int v1 = Integer.parseInt(line[0]);
            int v2 = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            list.add(new Edge(v1, v2, cost));
        }

        Collections.sort(list);

        int result = 0;
        int ct = 0;
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);

            if (union(edge.v1, edge.v2)) {
                result += edge.cost;

                if (++ct == V - 2) {
                    break;
                }
            }
        }

        System.out.println(result);
    }

    static int find(int v) {
        if (parent[v] == 0) {
            return v;
        }

        return parent[v] = find(parent[v]);
    }

    static boolean union(int v1, int v2) {
        int r1 = find(v1);
        int r2 = find(v2);

        if (r1 == r2) {
            return false;
        }

        parent[r2] = r1;

        return true;
    }
}

class Edge implements Comparable<Edge> {

    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}