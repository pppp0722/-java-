package test294;
// DP/백준/골드3/1943 동전 분배

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int TC = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TC; i++) {
            int max = 0;
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n + 1][2];

            for (int j = 1; j <= n; j++) {
                String[] split = br.readLine().split(" ");
                int c = Integer.parseInt(split[0]);
                int cn = Integer.parseInt(split[1]);
                max += c * cn;
                arr[j] = new int[]{c, cn};
            }

            boolean[] dp = new boolean[max / 2 + 1];
            dp[0] = true;

            if (max % 2 == 0) {
                for (int j = 1; j <= n; j++) {
                    int v = arr[j][0];
                    int q = arr[j][1];

                    for (int k = max / 2; k >= v; k--) {
                        if (dp[k - v]) {
                            for (int l = 1; l <= q; l++) {
                                int c = (k - v) + (v * l);

                                if (c > max / 2) {
                                    break;
                                }

                                dp[c] = true;
                            }
                        }
                    }
                }
            }

            sb.append(dp[max / 2] ? 1 : 0).append(System.lineSeparator());
        }

        System.out.print(sb);
    }
}