package test112;
// 백준/실버3/9095 1, 2, 3 더하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            System.out.println(getNumberOfCases(arr[i]));
        }
    }

    static int getNumberOfCases(int num) {
        int[] d = new int[num + 1];
        d[0] = 1;
        for (int i = 1; i <= num; i++) {
            d[i] += d[i - 1];
            if (i >= 2) {
                d[i] += d[i - 2];
            }
            if (i >= 3) {
                d[i] += d[i - 3];
            }
        }

        return d[num];
    }
}
