package test146;
// 백준/골드5/2230 수 고르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int l = 0;
        int r = 1;
        int answer = Integer.MAX_VALUE;
        while (l < N - 1 && r < N) {
            int diff = arr[r] - arr[l];
            if (diff < M) {
                r++;
            } else {
                answer = Math.min(diff, answer);
                if(l + 1 != r) {
                    l++;
                } else {
                    r++;
                }
            }
        }

        System.out.println(answer);
    }
}