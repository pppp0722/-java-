package test169;
// 백준/실버3/9461 파도반 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N + 1];
            dp[1] = 1;
            if (N > 1) {
                dp[2] = 1;
            }
            if (N > 2) {
                dp[3] = 1;
            }

            for (int j = 4; j <= N; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }

            System.out.println(dp[N]);
        }
    }
}
