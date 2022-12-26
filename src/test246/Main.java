package test246;
// DP/백준/실버1/4883 삼각 그래프

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n;
        int t = 1;
        long[][] matrix;
        long[][] dp;
        while (true) {
            // 초기화
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            matrix = new long[n][3];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = Long.parseLong(st.nextToken());
                }
            }

            // DP
            dp = new long[n][3];
            dp[0][1] = matrix[0][1];
            dp[0][2] = matrix[0][1] + matrix[0][2];
            dp[1][0] = dp[0][1] + matrix[1][0];
            dp[1][1] = Math.min(dp[0][1], dp[0][2]) + matrix[1][1];
            dp[1][2] = Math.min(dp[0][1], dp[0][2]) + matrix[1][2];
            dp[1][1] = Math.min(dp[1][0] + matrix[1][1], dp[1][1]);
            dp[1][2] = Math.min(dp[1][1] + matrix[1][2], dp[1][2]);
            for (int i = 2; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][0];
                dp[i][1] =
                    Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]) + matrix[i][1];
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + matrix[i][2];
                dp[i][1] = Math.min(dp[i][0] + matrix[i][1], dp[i][1]);
                dp[i][2] = Math.min(dp[i][1] + matrix[i][2], dp[i][2]);
            }

            sb.append(t++).append(". ").append(dp[n - 1][1]).append(lineSeparator());
        }

        System.out.println(sb);
    }
}
