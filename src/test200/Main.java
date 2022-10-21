package test200;
// 백준/실버1/11052 카드 구매하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(line[i - 1]);
        }

        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                dp[i] = Math.max(arr[j] + dp[i - j], dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}