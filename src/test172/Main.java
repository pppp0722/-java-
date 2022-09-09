package test172;
// 백준/실버1/10844 쉬운 계단 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                switch (j) {
                    case 0:
                        dp[i][j] = dp[i - 1][1] % MOD;
                        break;
                    case 9:
                        dp[i][j] = dp[i - 1][8] % MOD;
                        break;
                    default:
                        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                        break;
                }
            }
        }
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + dp[n][i]) % MOD;
        }
        System.out.println(answer);
    }
}
