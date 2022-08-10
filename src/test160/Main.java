package test160;
// 백준/실버1/12852 1로 만들기 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        String[] process = new String[N + 1];
        dp[1] = 0;
        process[1] = "1";

        for (int i = 2; i <= N; i++) {
            int ct = Integer.MAX_VALUE;
            String str = "";

            if (i % 3 == 0) {
                if (dp[i / 3] + 1 < ct) {
                    ct = dp[i / 3] + 1;
                    str = i + " " + process[i / 3];
                }
            }

            if (i % 2 == 0) {
                if (dp[i / 2] + 1 < ct) {
                    ct = dp[i / 2] + 1;
                    str = i + " " + process[i / 2];
                }
            }

            if (dp[i - 1] + 1 < ct) {
                ct = dp[i - 1] + 1;
                str = i + " " + process[i - 1];
            }

            dp[i] = ct;
            process[i] = str;
        }

        System.out.println(dp[N]);
        System.out.println(process[N]);
    }
}