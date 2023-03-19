package test267;
// 위상정렬/백준/골드3/2623 음악프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static List<List<Integer>> graph;
    private static int[] inDegrees;

    public static void main(String[] args) throws IOException {
        init();
        findOrder().forEach(System.out::println);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        inDegrees = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int k = Integer.parseInt(split[0]);
            for (int j = 1; j < k; j++) {
                int from = Integer.parseInt(split[j]);
                int to = Integer.parseInt(split[j + 1]);
                graph.get(from).add(to);
                inDegrees[to]++;
            }
        }
        br.close();
    }

    private static List<Integer> findOrder() {
        List<Integer> order = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            order.add(cur);
            for (int next : graph.get(cur)) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return order.size() == n ? order : new ArrayList<>(List.of(0));
    }
}
