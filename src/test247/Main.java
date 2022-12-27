package test247;
// DP/백준/골드4/1915 가장 큰 정사각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dArr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            line = br.readLine();
            for (int j = 1; j <= m; j++) {
                dArr[i][j] = line.charAt(j - 1) - '0';
            }
        }

        // DP
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dArr[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }

        System.out.println((int) Math.pow(answer, 2));
    }
}
