package test130;
// 백준/골드3/행렬 곱셈 순서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int d[] = new int[N + 1];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            d[i] = Integer.parseInt(split[0]);
            d[i + 1] = Integer.parseInt(split[1]);
        }

        long[][] dp = new long[N + 1][N + 1];
        for (int idx = 1; idx < N; idx++) {
            for (int i = 1; i <= N - idx; i++) {
                int j = i + idx;
                dp[i][j] = Long.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + d[i - 1] * d[k] * d[j], dp[i][j]);
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}
