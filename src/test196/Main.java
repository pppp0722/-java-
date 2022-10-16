package test196;
// 백준/실버1/2302 극장 좌석

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if(set.contains(i) || set.contains(i - 1)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        System.out.println(dp[n]);
    }
}
