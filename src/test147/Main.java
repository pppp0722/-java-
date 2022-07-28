package test147;
// 백준/골드4/1806 부분합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);
        int[] arr = new int[N];
        line = br.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(line[i]);
            arr[i] = sum;
        }

        int l = -1;
        int r = 0;
        int answer = N + 1;
        while (r < N) {
            int num1 = l == -1 ? 0 : arr[l];
            int num2 = arr[r];
            int diff = num2 - num1;

            if (diff < S) {
                r++;
            } else {
                answer = Math.min(r - l, answer);
                if (l + 1 == r) {
                    r++;
                } else {
                    l++;
                }
            }
        }

        System.out.println(answer == N + 1 ? 0 : answer);
    }
}
