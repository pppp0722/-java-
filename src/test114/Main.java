package test114;
// 백준/실버1/1149 RGB거리
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dArr = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            dArr[i] = arr;
        }

        int[][] d = new int[N + 1][3];
        d[1][0] = dArr[1][0];
        d[1][1] = dArr[1][1];
        d[1][2] = dArr[1][2];
        for (int i = 2; i <= N; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + dArr[i][0];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + dArr[i][1];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + dArr[i][2];
        }

        int min = d[N][0];
        for (int i = 1; i < 3; i++) {
            if (d[N][i] < min) {
                min = d[N][i];
            }
        }

        System.out.println(min);
    }
}
