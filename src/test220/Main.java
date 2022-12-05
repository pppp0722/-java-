package test220;
// DFS/백준/골드4/4803 트리

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;
    private static int n;
    private static int m;
    private static List<List<Integer>> tree;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = 1;
        while (init()) {
            int ct = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) {
                    continue;
                }

                if (dfs(-1, i)) {
                    ct++;
                }
            }

            sb.append(getResult(t, ct))
                .append(lineSeparator());

            t++;
        }

        System.out.println(sb);

        br.close();
    }

    private static boolean init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // "0 0" 입력 시 종료
        if (n == 0 && m == 0) {
            return false;
        }
        // tree, visited 초기화
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        // 간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            tree.get(v1).add(v2);
            tree.get(v2).add(v1);
        }
        return true;
    }

    private static boolean dfs(int parent, int v) {
        visited[v] = true;
        List<Integer> children = tree.get(v);
        for (int child : children) {
            if (child == parent) {
                continue;
            }
            if (visited[child] || !dfs(v, child)) {
                return false;
            }
        }
        return true;
    }

    private static String getResult(int t, int ct) {
        StringBuilder sb = new StringBuilder();
        sb.append("Case ").append(t).append(": ");
        if (ct == 0) {
            sb.append("No trees.");
        } else if (ct == 1) {
            sb.append("There is one tree.");
        } else {
            sb.append("A forest of ").append(ct).append(" trees.");
        }
        return sb.toString();
    }
}
