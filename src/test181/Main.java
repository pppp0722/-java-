package test181;
// LCS/백준/골드5/9251 LCS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int len1;
    private static int len2;
    private static char[] chars1;
    private static char[] chars2;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findLenOfLCS());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        len1 = str1.length();
        len2 = str2.length();
        chars1 = new char[len1 + 1];
        chars2 = new char[len2 + 1];
        for (int i = 1; i <= len1; i++) {
            chars1[i] = str1.charAt(i - 1);
        }
        for (int i = 1; i <= len2; i++) {
            chars2[i] = str2.charAt(i - 1);
        }
        br.close();
    }

    private static int findLenOfLCS() {
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
