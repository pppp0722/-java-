package test120;
// 백준/골드4/11404 플로이드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int[][] dist = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }

                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int E = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int cost = Integer.parseInt(line[2]);
            dist[from][to] = Math.min(cost, dist[from][to]);
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 1; k <= V; k++) {
                    if (dist[j][i] != Integer.MAX_VALUE && dist[i][k] != Integer.MAX_VALUE) {
                        dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                    }
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (dist[i][j] != Integer.MAX_VALUE) {
                    System.out.print(dist[i][j] + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }

            System.out.println();
        }
    }
}
