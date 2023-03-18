package test266;
// DP/백준/골드5/23083 꿀벌 승연이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MOD = 10_0000_0007;
    private static int n;
    private static int m;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findNumOfAllCases());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][m + 1];
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dp[x][y] = -1;
        }
        br.close();
    }

    private static int findNumOfAllCases() {
        // 초기화
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            if (dp[i][1] == -1) {
                break;
            }
            dp[i][1] = dp[1][1];
        }

        // DP
        for (int i = 2; i <= m; i++) {
            int add = (i % 2) * -1;
            for (int j = 1; j <= n; j++) {
                if (dp[j][i] == -1) {
                    continue;
                }
                if (j + add > 0 && dp[j + add][i - 1] != -1) {
                    dp[j][i] = dp[j + add][i - 1];
                }
                if (j + 1 + add <= n && dp[j + 1 + add][i - 1] != -1) {
                    dp[j][i] = (dp[j][i] + dp[j + 1 + add][i - 1]) % MOD;
                }
            }
            for (int j = 1; j < n; j++) {
                if (dp[j][i] != -1 && dp[j + 1][i] != -1) {
                    dp[j + 1][i] = (dp[j + 1][i] + dp[j][i]) % MOD;
                }
            }
        }
        return dp[n][m];
    }
}
