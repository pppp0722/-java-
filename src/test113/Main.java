package test113;
// 백준/실버3/2579 계단 오르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[N + 1];
        d[1] = arr[1];
        if (N > 1) {
            d[2] = arr[1] + arr[2];
        }
        if (N > 2) {
            d[3] = Math.max(d[1], d[0] + arr[2]) + arr[3];
        }

        for (int i = 3; i <= N; i++) {
            d[i] = Math.max(d[i - 2], d[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(d[N]);
    }
}