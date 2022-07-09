package test110;
// 백준/실버2/14889 스타트와 링크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[][] matrix;
    static boolean[] visited;
    static int minPowerDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            matrix[i] = row;
        }

        dfs(0, 0);

        System.out.println(minPowerDiff);
    }

    static void dfs(int depth, int index) {
        if (depth == N / 2) {
            int powerDiff = calcPowerDiff();
            minPowerDiff = Math.min(powerDiff, minPowerDiff);
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static int calcPowerDiff() {
        int power1 = 0;
        int power2 = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    power1 += matrix[i][j];
                    power1 += matrix[j][i];
                } else if (!visited[i] && !visited[j]) {
                    power2 += matrix[i][j];
                    power2 += matrix[j][i];
                }
            }
        }

        return Math.abs(power1 - power2);
    }
}