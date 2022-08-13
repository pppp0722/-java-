package test162;
// 백준/실버1/1932 정수 삼각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dArr = new int[N][N];
        dArr[0][0] = Integer.parseInt(br.readLine());
        for(int i = 1; i < N; i++) {
            int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            for(int j = 0; j < i; j++) {
                dArr[i][j] = arr[j] + dArr[i - 1][j];
            }

            for(int j = 0; j < i; j++) {
                dArr[i][j + 1] = Math.max(dArr[i - 1][j] + arr[j + 1], dArr[i][j + 1]);
            }
        }

        int answer = dArr[N - 1][0];
        for(int i = 1; i < N; i++) {
            answer = Math.max(dArr[N - 1][i], answer);
        }

        System.out.println(answer);
    }
}
