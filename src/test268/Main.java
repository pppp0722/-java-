package test268;
// DP,위상정렬/골드3/1005 ACM Craft

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int k;
    private static int w;
    private static List<List<Integer>> graph;
    private static int[] costs;
    private static int[] inDegree;


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            init();
            answer.append(findMinTime()).append(lineSeparator());
        }
        System.out.print(answer);
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        inDegree = new int[n + 1];
        costs = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            inDegree[to]++;
        }
        w = Integer.parseInt(br.readLine());
    }

    private static int findMinTime() {
        int[] dp = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                dp[i] = costs[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            int totalCost = dp[cur];

            if (cur == w) {
                break;
            }

            for (int next : graph.get(cur)) {
                dp[next] = Math.max(totalCost + costs[next], dp[next]);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return dp[w];
    }
}
