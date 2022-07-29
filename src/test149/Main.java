package test149;
// 백준/골드3/7570 줄 세우기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[N + 1];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(line[i]);
            arr[num] = arr[num - 1] + 1;
            max = Math.max(arr[num], max);
        }

        System.out.println(N - max);
    }
}
