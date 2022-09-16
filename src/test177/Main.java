package test177;
// 백준/골드4/11559 Puyo Puyo

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    private static final int R = 12;
    private static final int C = 6;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] field = new char[R][C];
        for (int i = 0; i < R; i++) {
            field[i] = br.readLine().toCharArray();
        }
        System.out.println(getCount(field));
    }

    public static int getCount(char[][] field) {
        int count = 0;
        while (true) {
            boolean[][] visited = new boolean[R][C];
            boolean check = false;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (field[i][j] != '.' && !visited[i][j]) {
                        check |= explode(field, visited, i, j);
                    }
                }
            }
            if (!check) {
                break;
            }
            count++;
            down(field);
        }
        return count;
    }

    public static boolean explode(char[][] field, boolean[][] visited, int x, int y) {
        char c = field[x][y];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        Stack<int[]> stack = new Stack<>();
        int count = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            count++;
            stack.push(p);
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (!isOOB(nx, ny) && !visited[nx][ny] && field[nx][ny] == c) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        boolean check = false;
        if (count >= 4) {
            while (!stack.isEmpty()) {
                int[] p = stack.pop();
                field[p[0]][p[1]] = '.';
            }
            check = true;
        }
        return check;
    }

    public static void down(char[][] field) {
        for (int i = 0; i < C; i++) {
            for (int j = R - 2; j >= 0; j--) {
                if (field[j][i] != '.') {
                    int y = j;
                    while (y + 1 < R && field[y + 1][i] == '.') {
                        y++;
                    }
                    if (y != j) {
                        field[y][i] = field[j][i];
                        field[j][i] = '.';
                    }
                }
            }
        }
    }

    public static boolean isOOB(int x, int y) {
        boolean check = false;
        if (x < 0 || x >= R || y < 0 || y >= C) {
            check = true;
        }
        return check;
    }
}
