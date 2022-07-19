package test136;
// 백준/골드5/2240 자두나무

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int T = Integer.parseInt(line[0]);
        int W = Integer.parseInt(line[1]);
        int[] treeIdxArr = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            treeIdxArr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[T + 1][W + 1];
        for (int i = 1; i <= T; i++) {
            int treeIdx = treeIdxArr[i];
            int maxMove = Math.min(i, W);
            dp[i][0] = dp[i - 1][0] + (treeIdx % 2);
            for (int j = 1; j <= maxMove; j++) {
                int fall = 0;
                if (treeIdx == 1 && j % 2 == 0) {
                    fall = 1;
                } else if (treeIdx == 2 && j % 2 == 1) {
                    fall = 1;
                }
                int stay = dp[i - 1][j] + fall;
                int move = dp[i - 1][j - 1] + fall;
                dp[i][j] = Math.max(stay, move);
            }
        }

        int answer = dp[T][0];
        for (int i = 1; i <= W; i++) {
            answer = Math.max(dp[T][i], answer);
        }

        System.out.println(answer);
    }
}
