package test166;
// 백준/실버2/11055 가장 큰 증가 부분 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];

            int num = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && arr[j] > num) {
                    dp[i] = Math.max(arr[i] + dp[j], dp[i]);
                }
            }
        }

        int answer = dp[0];
        for(int i = 1; i < N; i++) {
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}
