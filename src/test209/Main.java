package test209;
// DP/백준/실버1/11057 오르막 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int TEN = 10;
    private static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][TEN];
        for (int i = 0; i < TEN; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < TEN; j++) {
                for (int k = j; k < TEN; k++) {
                    dp[i][k] = (dp[i][k] + dp[i - 1][j]) % MOD;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < TEN; i++) {
            answer = (answer + dp[n][i]) % MOD;
        }

        System.out.println(answer);
    }
}
