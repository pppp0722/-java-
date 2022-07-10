package test121;
// 백준/골드3/2252 줄 세우기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int[] inDegree = new int[V + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        int E = Integer.parseInt(line[1]);
        for (int i = 0; i < E; i++) {
            line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            graph.get(from).add(to);
            inDegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i = 1; i <= V; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            Integer from = q.poll();
            result.offer(from);

            for (Integer to : graph.get(from)) {
                inDegree[to]--;

                if (inDegree[to] == 0) {
                    q.offer(to);
                }
            }
        }

        while (!result.isEmpty()) {
            System.out.print(result.poll() + " ");
        }
    }
}
