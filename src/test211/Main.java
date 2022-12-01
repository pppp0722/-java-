package test211;
// BFS/백준/골드4/1261 알고스팟

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static int n;
    private static int m;
    private static int[][] maze;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        m = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);
        maze = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = row.charAt(j) - '0';
            }
        }

        // 우선순위 큐를 사용한 BFS
        int answer = 0;
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.offer(new Position(0, 0, 0));
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            Position pos = pq.poll();

            if (isGoal(pos.x, pos.y)) {
                answer = pos.depth;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + DX[i];
                int ny = pos.y + DY[i];

                if (isOOB(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                if (isWall(nx, ny)) {
                    pq.offer(new Position(nx, ny, pos.depth + 1));
                } else {
                    pq.offer(new Position(nx, ny, pos.depth));
                }

                visited[nx][ny] = true;
            }
        }

        System.out.println(answer);
    }

    private static boolean isOOB(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return true;
        }
        return false;
    }

    private static boolean isWall(int x, int y) {
        return maze[x][y] == 1;
    }

    private static boolean isGoal(int x, int y) {
        return x == n - 1 && y == m - 1;
    }
}

class Position implements Comparable<Position> {

    public int x;
    public int y;
    public int depth;

    public Position(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }

    @Override
    public int compareTo(Position o) {
        return depth - o.depth;
    }
}
