package test226;
// DFS,그리디/백준/골드2/3109 빵집

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int r;
    private static int c;
    private static boolean[][] isEmpty;
    private static int answer;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        isEmpty = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            line = br.readLine();
            for (int j = 0; j < c; j++) {
                isEmpty[i][j] = line.charAt(j) == '.';
            }
        }

        // DFS
        for (int i = r - 1; i >= 0; i--) {
            int[] path = new int[c];
            path[0] = i;
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    public static boolean dfs(int x, int y) {
        isEmpty[x][y] = false;
        if (y == c - 1) {
            answer++;
            return true;
        }

        // 오른쪽 아래 대각선
        int ny = y + 1;
        int nx = x + 1;
        if (!isOOB(nx, ny) && isEmpty[nx][ny]) {
            if (dfs(nx, ny)) {
                return true;
            }
        }
        // 오른쪽
        nx = x;
        if (!isOOB(nx, ny) && isEmpty[nx][ny]) {
            if (dfs(nx, ny)) {
                return true;
            }
        }
        // 오른쪽 위 대각선
        nx = x - 1;
        if (!isOOB(nx, ny) && isEmpty[nx][ny]) {
            if (dfs(nx, ny)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isOOB(int x, int y) {
        if (x < 0 || x >= r || y < 0 || y >= c) {
            return true;
        }
        return false;
    }
}
