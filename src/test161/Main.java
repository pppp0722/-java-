package test161;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n + 1][2];
            dp[0][0] = 1;
            if(n > 0) {
                dp[1][1] = 1;
            }

            for (int j = 2; j <= n; j++) {
                dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
            }

            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}