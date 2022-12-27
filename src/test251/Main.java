package test251;
// DP/백준/골드5/2249 동전 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // DP
        int[] dp = new int[k + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= k; j++) {
                dp[j] = Math.min(dp[j - coin] + 1, dp[j]);
            }
        }

        System.out.println(dp[k] == MAX ? -1 : dp[k]);
    }
}
