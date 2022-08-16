package test165;
// 백준/실버2/1912 연속합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        String[] line = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(line[i - 1]);
        }
        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        }
        int max = dp[1];
        for(int i = 1; i <= N; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
