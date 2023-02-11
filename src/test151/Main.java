package test151;
// DP/백준/골드3/1520 내리막길

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findNumOfPaths(n - 1, m - 1));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        memo = new int[n][m];
        visited = new boolean[n][m];
        memo[0][0] = 1;
        visited[0][0] = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int findNumOfPaths(int x, int y) {
        if (visited[x][y]) {
            return memo[x][y];
        }
        visited[x][y] = true;

        int numOfPaths = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (isOOB(nx, ny) || map[nx][ny] <= map[x][y]) {
                continue;
            }

            numOfPaths += findNumOfPaths(nx, ny);
        }

        return memo[x][y] = numOfPaths;
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }
}
