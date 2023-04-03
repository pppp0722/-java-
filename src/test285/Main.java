package test285;
// DFS/백준/골드4/1987 알파벳

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static final Set<Character> set = new HashSet<>();
    private static int r;
    private static int c;
    private static char[][] board;
    private static boolean[][] visited;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        visited = new boolean[r][c];
        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // DFS
        set.add(board[0][0]);
        dfs(1, 0, 0);

        System.out.println(max);
    }

    private static void dfs(int depth, int x, int y) {
        max = Math.max(depth, max);

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (isOOB(nx, ny) || visited[nx][ny] || set.contains(board[nx][ny])) {
                continue;
            }

            visited[nx][ny] = true;
            set.add(board[nx][ny]);
            dfs(depth + 1, nx, ny);
            visited[nx][ny] = false;
            set.remove(board[nx][ny]);
        }
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= r || y < 0 || y >= c;
    }
}
