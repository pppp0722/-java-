package test131;
// 프로그래머스/Level3/등굣길

class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }

        for (int i = 2; i <= m; i++) {
            if (dp[i][1] == -1) {
                break;
            }

            dp[i][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            if (dp[1][i] == -1) {
                break;
            }

            dp[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }

                int up = dp[i - 1][j] == -1 ? 0 : dp[i - 1][j];
                int left = dp[i][j - 1] == -1 ? 0 : dp[i][j - 1];
                dp[i][j] = (up + left) % 1_000_000_007;
            }
        }

        return dp[m][n];
    }
}

public class Test131 {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        int answer = new Solution().solution(m, n, puddles);
        System.out.println(answer);
    }
}
