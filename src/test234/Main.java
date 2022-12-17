package test234;
// DP/백준/브론즈1/2748 피보나치 수 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static long[] memo;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(dp(n));
    }

    private static long dp(int num) {
        if (num == 1 || num == 0) {
            return num;
        }

        if (memo[num] != 0) {
            return memo[num];
        }
        return memo[num] = dp(num - 1) + dp(num - 2);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new long[n + 1];
        br.close();
    }
}