package test103;
// 프로그래머스/Level3/경주로 건설

import java.util.LinkedList;
import java.util.Queue;

public class Test103 {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int result = new Solution().solution(board);
        System.out.println(result);
    }
}

class Solution {

    int N;
    boolean[][][] visited;
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int solution(int[][] board) {
        N = board.length;
        visited = new boolean[N][N][4];

        return bfs(board);
    }

    int bfs(int[][] board) {
        int minCost = Integer.MAX_VALUE;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, -1, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == N - 1 && p.y == N - 1) {
                minCost = Math.min(p.cost, minCost);
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dirs[i][0];
                int ny = p.y + dirs[i][1];
                if (!isOOB(nx, ny) && board[nx][ny] != 1) {
                    int nextCost;
                    if (p.dir == i || p.dir == -1) {
                        nextCost = p.cost + 100;
                    } else {
                        nextCost = p.cost + 600;
                    }
                    if (!visited[nx][ny][i] || nextCost <= board[nx][ny]) {
                        q.offer(new Point(nx, ny, i, nextCost));
                        visited[nx][ny][i] = true;
                        board[nx][ny] = nextCost;
                    }
                }
            }
        }

        return minCost;
    }

    boolean isOOB(int x, int y) {
        if (x < 0) {
            return true;
        }
        if (x >= N) {
            return true;
        }
        if (y < 0) {
            return true;
        }
        if (y >= N) {
            return true;
        }

        return false;
    }
}

class Point {

    int x;
    int y;
    int dir;
    int cost;

    public Point(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}