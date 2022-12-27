package test252;
// DP/백준/실버2/1699 제곱수의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // DP
        int[] dp = new int[n + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
            }
        }

        // 출력
        System.out.println(dp[n]);
    }
}
