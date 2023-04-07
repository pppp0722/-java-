package test290;
// BFS/백준/골드3/2206 벽 부수고 이동하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        // BFS
        int answer = -1;
        boolean[][][] visited = new boolean[n + 1][m + 1][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1, 0, 1});

        while (!q.isEmpty()) {
            int[] c = q.poll();

            if (c[0] == n && c[1] == m) {
                answer = c[3];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = c[0] + DX[i];
                int ny = c[1] + DY[i];

                if (isOOB(nx, ny)) {
                    continue;
                }

                if (map[nx][ny] == '0') {
                    if (visited[nx][ny][c[2]]) {
                        continue;
                    }

                    q.offer(new int[]{nx, ny, c[2], c[3] + 1});
                    visited[nx][ny][c[2]] = true;
                } else {
                    if (c[2] == 1 || visited[nx][ny][c[2] + 1]) {
                        continue;
                    }

                    q.offer(new int[]{nx, ny, c[2] + 1, c[3] + 1});
                    visited[nx][ny][c[2] + 1] = true;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean isOOB(int x, int y) {
        return x < 1 || x > n || y < 1 || y > m;
    }
}
