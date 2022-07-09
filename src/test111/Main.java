package test111;
// 백준/실버3/1463 1로 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        d = new int[num + 1];
        d[1] = 0;
        for (int i = 2; i <= num; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0) {
                d[i] = Math.min(d[i / 2] + 1, d[i]);
            }
            if (i % 3 == 0) {
                d[i] = Math.min(d[i / 3] + 1, d[i]);
            }
        }

        System.out.println(d[num]);
    }
}