package test124;
// 백준/골드4/9663 N-Queen

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] queens;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queens = new int[N + 1];

        backtrack(1);

        System.out.println(answer);
    }

    public static void backtrack(int r) {
        if (r == N + 1) {
            answer++;
            return;
        }

        // columns
        for (int i = 1; i <= N; i++) {
            if (queens[r] == 0 && isSafe(r, i)) {
                queens[r] = i;
                backtrack(r + 1);
                queens[r] = 0;
            }
        }
    }

    public static boolean isSafe(int r, int c) {
        // rows
        for (int i = 1; i < r; i++) {
            int opR = i;
            int opC = queens[i];

            if (c == opC || Math.abs(r - opR) == Math.abs(c - opC)) {
                return false;
            }
        }

        return true;
    }
}