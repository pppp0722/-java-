package test175;
// 백준/골드5/12865 평범한 배낭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[][] infos = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            line = br.readLine().split(" ");
            int[] info = new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])};
            infos[i] = info;
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int[] info = infos[i];
            for (int j = 1; j <= k; j++) {
                if (j < info[0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - info[0]] + info[1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
