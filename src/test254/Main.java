package test254;
// DP/백준/실버3/1788 피보나치 수의 확장

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 1_000_000_000;
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[Math.abs(n) + 1];

        // DP
        int answer = dp(Math.abs(n));

        // 출력
        System.out.println(n < 0 && n % 2 == 0 ? -1 : n == 0 ? 0 : 1);
        System.out.println(answer);
    }

    private static int dp(int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        if (memo[num] != 0) {
            return memo[num];
        }

        return memo[num] = (dp(num - 1) + dp(num - 2)) % MOD;
    }
}
