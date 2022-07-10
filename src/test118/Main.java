package test118;
// 백준/골드4/1744 수 묶기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long result = 0;
        int r = N - 1;
        while (r > 0 && arr[r - 1] > 1) {
            result += (long) arr[r] * arr[r - 1];
            r -= 2;
        }
        while (r >= 0 && arr[r] > 0) {
            result += arr[r];
            r--;
        }
        int l = 0;
        while (l < r) {
            result += (long) arr[l] * arr[l + 1];
            l += 2;
        }
        if (l == r) {
            result += arr[l];
        }

        System.out.println(result);
    }
}
