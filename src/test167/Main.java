package test167;
// 백준/실버2/11053 가장 긴 증가하는 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = IntStream.of(dp)
            .max()
            .orElse(-1);

        System.out.println(max);
    }
}
