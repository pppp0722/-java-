package test150;
// DP/백준/골드4/2482 색상환

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 1_000_000_003;
    private static int n;
    private static int k;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findNumberOfCases());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        br.close();
    }

    private static int findNumberOfCases() {
        if (k > n / 2) {
            return 0;
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
        }
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }
        return dp[n][k];
    }
}