package test151;
// 백준/골드3/1520 내리막길

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new int[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                map[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(topDown(N - 1, M - 1));
    }

    static int topDown(int x, int y) {
        if (visited[x][y]) {
            return dp[x][y];
        }

        visited[x][y] = true;

        if (x == 0 && y == 0) {
            dp[0][0] = 1;
            return 1;
        }

        int u = 0;
        if (x - 1 >= 0 && map[x - 1][y] > map[x][y]) {
            u = topDown(x - 1, y);
        }
        int r = 0;
        if (y + 1 < M && map[x][y + 1] > map[x][y]) {
            r = topDown(x, y + 1);
        }
        int d = 0;
        if (x + 1 < N && map[x + 1][y] > map[x][y]) {
            d = topDown(x + 1, y);
        }
        int l = 0;
        if (y - 1 >= 0 && map[x][y - 1] > map[x][y]) {
            l = topDown(x, y - 1);
        }

        int path = u + r + d + l;

        dp[x][y] = path;

        return path;
    }
}
