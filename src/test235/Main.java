package test235;
// DP/백준/실버1/9465 스티커

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[n + 2][2];
            st = new StringTokenizer(br.readLine());
            for (int j = 2; j < n + 2; j++) {
                stickers[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 2; j < n + 2; j++) {
                stickers[j][1] = Integer.parseInt(st.nextToken());
            }

            // DP
            int[][] dp = new int[n + 2][2];
            for (int j = 2; j < n + 2; j++) {
                int max = Math.max(dp[j - 2][0], dp[j - 2][1]);
                dp[j][0] = stickers[j][0] + Math.max(dp[j - 1][1], max);
                dp[j][1] = stickers[j][1] + Math.max(dp[j - 1][0], max);
            }

            int maxScore = 0;
            for (int j = 2; j < n + 2; j++) {
                maxScore = Math.max(dp[j][0], maxScore);
                maxScore = Math.max(dp[j][1], maxScore);
            }
            sb.append(maxScore).append(lineSeparator());
        }

        System.out.println(sb);
    }
}
