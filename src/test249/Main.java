package test249;
// DP/백준/골드4/10942 팰린드롬?

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[][] queries = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }

        // DP
        boolean[][] dp = new boolean[n + 1][n + 1];
        // 길이 1
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        // 길이 2
        for (int i = 2; i <= n; i++) {
            if (arr[i - 1] == arr[i]) {
                dp[i - 1][i] = true;
            }
        }
        // 길이 3 이상
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                if (arr[j] == arr[j + i - 1] && dp[j + 1][j + i - 2]) {
                    dp[j][j + i - 1] = true;
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(dp[queries[i][0]][queries[i][1]] ? 1 : 0).append(lineSeparator());
        }
        System.out.println(sb);
    }
}
