package test230;
// 그리디/백준/실버4/11047 동전 0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splitLine = br.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int k = Integer.parseInt(splitLine[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 그리디
        int answer = 0;
        int remaining = k;
        for (int i = n - 1; i >= 0; i--) {
            int coin = arr[i];
            if (remaining >= coin) {
                int count = remaining / coin;
                remaining -= coin * count;
                answer += count;
            }
        }

        System.out.println(answer);
    }
}
