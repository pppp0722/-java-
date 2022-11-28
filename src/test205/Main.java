package test205;
// 이탐/백준/실버2/1654 랜선 자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int k = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        int[] arr = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        // 이분 탐색
        long l = 1;
        long r = max;
        while (l <= r) {
            long m = (l + r) / 2;
            long ct = 0;
            for (int i = 0; i < k; i++) {
                ct += arr[i] / m;
            }

            if (ct >= n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.println(r);
    }
}
