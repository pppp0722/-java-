package test159;
// 백준/실버3/11659 구간 합 구하기 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(line[i]);
            arr[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int idx1 = Integer.parseInt(line[0]) - 2;
            int idx2 = Integer.parseInt(line[1]) - 1;
            int num = arr[idx2] - (idx1 == -1 ? 0 : arr[idx1]);
            System.out.println(num);
        }
    }
}
