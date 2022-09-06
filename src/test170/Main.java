package test170;
// 백준/실버3/14501 퇴사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] infos = new int[n + 1][2];
        for(int i = 1; i <= n; i++) {
            int[] info = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            infos[i] = info;
        }

        int[] dp = new int[n + 2];
        for(int i = 1; i <= n + 1; i++) {
            for(int j = 1; j < i; j++) {
                int[] info = infos[j];
                dp[i] = Math.max(dp[j], dp[i]);
                if(j + info[0] == i) {
                    dp[i] = Math.max(dp[j] + info[1], dp[i]);
                }
            }
        }

        System.out.println(dp[n + 1]);
    }
}
