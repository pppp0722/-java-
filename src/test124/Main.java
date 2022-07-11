package test124;
// 백준/골드4/9663 N-Queen

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] queens;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queens = new int[N];

        backtrack(0);

        System.out.println(result);
    }

    static void backtrack(int row) {
        if (row == N) {
            result++;

            return;
        }

        for (int i = 0; i < N; i++) {
            queens[row] = i;

            if (isSafe(row)) {
                backtrack(row + 1);
            }
        }
    }

    static boolean isSafe(int row) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row]) {
                return false;
            }

            if (Math.abs(i - row) == Math.abs(queens[i] - queens[row])) {
                return false;
            }
        }

        return true;
    }
}