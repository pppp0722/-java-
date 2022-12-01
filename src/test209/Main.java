package test209;
// DP/백준/실버1/11057 오르막 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int TEN = 10;
    private static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 2차원 DP 배열 초기화 ([자릿수][마지막 자리 숫자])
        int[][] dp = new int[n + 1][TEN];
        for (int i = 0; i < TEN; i++) {
            dp[1][i] = 1;
        }

        // DP
        for (int i = 2; i <= n; i++) {
            // 이전 수 마지막 자리 숫자 -> j, 다음 수 마지막 자리 숫자 -> k
            for (int j = 0; j < TEN; j++) {
                for (int k = j; k < TEN; k++) {
                    // 다음 수의 마지막 자리 숫자 k가 가능한 경우를 모두 더해줌
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
