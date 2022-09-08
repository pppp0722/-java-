package test171;
// 백준/실버1/15486 퇴사2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            t[i] = Integer.parseInt(line[0]);
            p[i] = Integer.parseInt(line[1]);
        }

        int[] dp = new int[n + 2];
        for (int i = n; i >= 1; i--) {
            if (i + t[i] > n + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(p[i] + dp[i + t[i]], dp[i + 1]);
            }
        }

        System.out.println(dp[1]);
    }
}