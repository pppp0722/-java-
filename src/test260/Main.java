package test260;
// 유파/백준/골드4/1717 집합의 표현

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // union-find
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(n1, n2);
            } else {
                String answer = "NO";
                if (isSameRoot(n1, n2)) {
                    answer = "YES";
                }
                sb.append(answer).append(lineSeparator());
            }
        }

        // 출력
        System.out.println(sb);
        br.close();
    }

    public static boolean isSameRoot(int n1, int n2) {
        return find(n1) == find(n2);
    }

    public static void union(int n1, int n2) {
        n1 = find(n1);
        n2 = find(n2);
        if (n1 != n2) {
            parent[n1] = n2;
        }
    }

    public static int find(int n) {
        if (n == parent[n]) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }
}
