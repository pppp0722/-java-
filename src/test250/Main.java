package test250;
// DP/백준/골드5/2011 암호코드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = line.length();
        if (line.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        // DP
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        boolean zero = false;
        for (int i = 2; i <= n; i++) {
            if (line.charAt(i - 1) == '0') {
                if (zero) {
                    dp[n] = 0;
                    break;
                }
                zero = true;
            } else {
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
                zero = false;
            }
            if (isWord(line.substring(i - 2, i))) {
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }

        System.out.println(dp[n]);
    }

    private static boolean isWord(String word) {
        if (word.charAt(0) == '0') {
            return false;
        }
        return word.compareTo("26") < 1;
    }
}
