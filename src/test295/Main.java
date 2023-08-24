package test295;
// BFS/백준/골드5/10026 적록색약

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    private static int n;
    private static char[][] matrix;

    public static void main(String[] args) throws IOException {
        init();
        String answer = findNumOfAreas(false) + " " + findNumOfAreas(true);
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }

    private static int findNumOfAreas(boolean isColorWeakness) {
        int numOfAreas = 0;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(visited, new int[]{i, j}, isColorWeakness);
                    numOfAreas++;
                }
            }
        }

        return numOfAreas;
    }

    private static void bfs(boolean[][] visited, int[] p, boolean isColorWeakness) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(p);
        char color = matrix[p[0]][p[1]];
        visited[p[0]][p[1]] = true;

        while (!q.isEmpty()) {
            int[] cp = q.poll();
            int cx = cp[0];
            int cy = cp[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (isOOB(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                char nextColor = matrix[nx][ny];
                if (!isColorSame(color, nextColor, isColorWeakness)) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    private static boolean isColorSame(char color1, char color2, boolean isColorWeakness) {
        if (color1 == color2) {
            return true;
        }
        if (isColorWeakness) {
            String s = String.valueOf(color1) + color2;
            return "RG".equals(s) || "GR".equals(s);
        }
        return false;
    }
}
