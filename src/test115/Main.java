package test115;
// 백준/실버3/11726 2xn 타일링

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] d = new int[N + 1];
        d[1] = 1;
        if(N > 1) {
            d[2] = 2;
        }
        for (int i = 3; i <= N; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 10007;
        }

        System.out.println(d[N] % 10007);
    }
}
