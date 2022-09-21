package test189;
// 백준/골드4/4179 불!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int r;
    public static int c;
    public static char[][] map;
    public static Queue<Point> q;
    public static int[] init;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);
        map = new char[r][c];
        q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                char ch = input.charAt(j);
                map[i][j] = ch;
                if (ch == 'J') {
                    init = new int[]{i, j};
                }
                if (ch == 'F') {
                    q.offer(new Point(i, j, 0, false));
                }
            }
        }

        int answer = bfs();
        System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
    }

    public static int bfs() {
        q.offer(new Point(init[0], init[1], 0, true));
        boolean[][] visited = new boolean[r][c];

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.isUser && (p.x == 0 || p.x == r - 1 || p.y == 0 || p.y == c - 1)) {
                return p.ct + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (isOOB(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, p.ct + 1, p.isUser));
            }
        }

        return -1;
    }

    public static boolean isOOB(int x, int y) {
        if (x < 0 || x >= r || y < 0 || y >= c || map[x][y] == '#') {
            return true;
        }

        return false;
    }
}

class Point {

    public int x;
    public int y;
    public int ct;
    public boolean isUser;

    public Point(int x, int y, int ct, boolean isUser) {
        this.x = x;
        this.y = y;
        this.ct = ct;
        this.isUser = isUser;
    }
}