package test240;
// 구현/백준/골드4/14500 테트로미노

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findMax());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
    }

    private static int findMax() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(findCurMax(i, j), max);
            }
        }
        return max;
    }

    private static int findCurMax(int x, int y) {
        int max = 0;
        int cur;
        // ㅣ 모양
        if (x + 3 < n) {
            cur = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 3][y];
            max = Math.max(cur, max);
        }
        if (y + 3 < m) {
            cur = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x][y + 3];
            max = Math.max(cur, max);
        }

        // ㅁ 모양
        if (x + 1 < n && y + 1 < m) {
            cur = map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 1][y];
            max = Math.max(cur, max);
        }

        // L 모양
        if (x + 2 < n && y + 1 < m) {
            cur = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 2][y + 1];
            max = Math.max(cur, max);

            cur = map[x][y + 1] + map[x][y] + map[x + 1][y] + map[x + 2][y];
            max = Math.max(cur, max);

            cur = map[x][y + 1] + map[x + 1][y + 1] + map[x + 2][y + 1] + map[x + 2][y];
            max = Math.max(cur, max);

            cur = map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 2][y + 1];
            max = Math.max(cur, max);
        }
        if (x + 1 < n && y + 2 < m) {
            cur = map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 1][y + 2];
            max = Math.max(cur, max);

            cur = map[x + 1][y] + map[x + 1][y + 1] + map[x + 1][y + 2] + map[x][y + 2];
            max = Math.max(cur, max);

            cur = map[x + 1][y] + map[x][y] + map[x][y + 1] + map[x][y + 2];
            max = Math.max(cur, max);

            cur = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 2];
            max = Math.max(cur, max);
        }

        // Z 모양
        if (x + 2 < n && y + 1 < m) {
            cur = map[x][y] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 2][y + 1];
            max = Math.max(cur, max);

            cur = map[x][y + 1] + map[x + 1][y + 1] + map[x + 1][y] + map[x + 2][y];
            max = Math.max(cur, max);
        }
        if (x + 1 < n && y + 2 < m) {
            cur = map[x][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 1][y + 2];
            max = Math.max(cur, max);

            cur = map[x + 1][y] + map[x + 1][y + 1] + map[x][y + 1] + map[x][y + 2];
            max = Math.max(cur, max);
        }

        // T 모양
        if (x + 2 < n && y + 1 < m) {
            cur = map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1];
            max = Math.max(cur, max);

            cur = map[x + 1][y] + map[x][y + 1] + map[x + 1][y + 1] + map[x + 2][y + 1];
            max = Math.max(cur, max);
        }
        if (x + 1 < n && y + 2 < m) {
            cur = map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1];
            max = Math.max(cur, max);

            cur = map[x][y + 1] + map[x + 1][y] + map[x + 1][y + 1] + map[x + 1][y + 2];
            max = Math.max(cur, max);
        }

        return max;
    }
}
