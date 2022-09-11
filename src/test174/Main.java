package test174;
// 백준/실버1/2156 포도주 시식

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][] dp = new int[n + 1][3];
        dp[1][0] = 0;
        dp[1][1] = arr[1];
        if(n > 1) {
            dp[2][0] = arr[1];
            dp[2][1] = arr[2];
            dp[2][2] = arr[1] + arr[2];
        }
        for(int i = 3; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][0] = Math.max(dp[i - 1][j], dp[i][0]);
            }
            for(int j = 0; j < 3; j++) {
                dp[i][1] = Math.max(dp[i - 2][j] + arr[i], dp[i][1]);
            }
            dp[i][2] = dp[i - 1][1] + arr[i];
        }

        int answer = 0;
        for(int i = 0; i < 3; i++) {
            answer = Math.max(dp[n][i], answer);
        }
        System.out.println(answer);
    }
}