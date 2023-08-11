package test189;
// BFS/백준/골드4/4179 불!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    private static int r;
    private static int c;
    private static char[][] matrix;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splitLine = br.readLine().split(" ");
        r = Integer.parseInt(splitLine[0]);
        c = Integer.parseInt(splitLine[1]);
        matrix = new char[r][c];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] jihoonVisited = new boolean[r][c];
        boolean[][] fireVisited = new boolean[r][c];
        int x = 0;
        int y = 0;
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                char ch = line.charAt(j);
                matrix[i][j] = ch;
                if (ch == 'J') {
                    jihoonVisited[i][j] = true;
                    x = i;
                    y = j;
                } else if (ch == 'F') {
                    fireVisited[i][j] = true;
                    q.offer(new int[]{i, j, 1, 1});
                }
            }
        }
        q.offer(new int[]{x, y, 0, 1});

        // BFS
        while (!q.isEmpty()) {
            int[] cp = q.poll();
            int cx = cp[0];
            int cy = cp[1];
            int type = cp[2]; // 0: 지훈, 1: 불
            int ct = cp[3];

            if (0 == type && (cx == 0 || cx == r - 1 || cy == 0 || cy == c - 1)) {
                System.out.println(ct);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (isOOB(nx, ny)) {
                    continue;
                }

                if (0 == type && (jihoonVisited[nx][ny] || fireVisited[nx][ny])) {
                    continue;
                }

                if (1 == type && fireVisited[nx][ny]) {
                    continue;
                }

                if (type == 0) {
                    jihoonVisited[nx][ny] = true;
                } else {
                    fireVisited[nx][ny] = true;
                }
                q.offer(new int[]{nx, ny, type, ct + 1});
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= r || y < 0 || y >= c || '#' == matrix[x][y];
    }
}