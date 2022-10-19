package test198;
// 백준/골드4/14499 주사위 굴리기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static final int[] DX = {0, 0, 0, -1, 1}; // 동, 서, 북, 남
    private static final int[] DY = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = {0, 0, 0, 0, 0, 0, 0};
        st = new StringTokenizer(br.readLine());
        int cx = x;
        int cy = y;
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());

            if (isOOB(cx + DX[dir], cy + DY[dir])) {
                continue;
            }

            int nx = cx + DX[dir];
            int ny = cy + DY[dir];

            rotate(dice, dir);

            System.out.println(dice[1]);

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            } else {
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }

            cx = nx;
            cy = ny;
        }
    }

    public static boolean isOOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    public static void rotate(int[] dice, int dir) {
        int tmp = dice[1];
        if (dir == 1) {
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = tmp;
        } else if (dir == 2) {
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = tmp;
        } else if (dir == 3) {
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = tmp;
        } else {
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = tmp;
        }
    }
}
