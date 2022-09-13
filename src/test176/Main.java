package test176;
// 백준/골드2/12100 2048 (Easy)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final int MOVE = 5;

    private static int n;
    private static int[][] board;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        answer = 0;

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if (depth == MOVE) {
            findMax();
            return;
        }

        int copy[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = board[i].clone();
        }
        for (int i = 0; i < 4; i++) {
            move(i);
            dfs(depth + 1);
            for (int j = 0; j < n; j++) {
                board[j] = copy[j].clone();
            }
        }
    }

    public static void move(int dir) {
        switch (dir) {
            case 0:
                for (int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j = 0; j < n; j++) {
                        if (board[j][i] != 0) {
                            if (block == board[j][i]) {
                                board[index - 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            } else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for (int j = n - 1; j >= 0; j--) {
                        if (board[j][i] != 0) {
                            if (block == board[j][i]) {
                                board[index + 1][i] = block * 2;
                                block = 0;
                                board[j][i] = 0;
                            } else {
                                block = board[j][i];
                                board[j][i] = 0;
                                board[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    int index = 0;
                    int block = 0;
                    for (int j = 0; j < n; j++) {
                        if (board[i][j] != 0) {
                            if (block == board[i][j]) {
                                board[i][index - 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            } else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < n; i++) {
                    int index = n - 1;
                    int block = 0;
                    for (int j = n - 1; j >= 0; j--) {
                        if (board[i][j] != 0) {
                            if (block == board[i][j]) {
                                board[i][index + 1] = block * 2;
                                block = 0;
                                board[i][j] = 0;
                            } else {
                                block = board[i][j];
                                board[i][j] = 0;
                                board[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }

    public static void findMax() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }
    }
}
