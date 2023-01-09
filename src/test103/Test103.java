package test103;
// BFS/프로그래머스/Level3/경주로 건설

import java.util.Arrays;
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

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private int[][] board;
    private int[][][] cost;
    private int n;

    public int solution(int[][] board) {
        init(board);
        return findMinCost();
    }

    private void init(int[][] board) {
        this.board = board;
        n = board.length;
        cost = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        Arrays.fill(cost[0][0], 0);
    }

    private int findMinCost() {
        int minCost = Integer.MAX_VALUE;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, -1, 0));
        while (!q.isEmpty()) {
            Point cp = q.poll();
            if (isGoal(cp.x, cp.y)) {
                minCost = Math.min(cp.c, minCost);
            }
            for (int i = 0; i < 4; i++) {
                int nx = cp.x + DX[i];
                int ny = cp.y + DY[i];
                int nc;
                if (cp.d == -1 || cp.d == i) {
                    nc = cp.c + 100;
                } else {
                    nc = cp.c + 600;
                }
                if (isOOB(nx, ny) || !isMinCost(nx, ny, i, nc)) {
                    continue;
                }
                q.offer(new Point(nx, ny, i, nc));
                cost[nx][ny][i] = nc;
            }
        }
        return minCost;
    }

    private boolean isGoal(int x, int y) {
        return x == n - 1 && y == n - 1;
    }

    private boolean isOOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n || board[x][y] == 1;
    }

    private boolean isMinCost(int x, int y, int i, int c) {
        return c < cost[x][y][i];
    }
}

class Point {

    public int x, y, d, c;

    public Point(int x, int y, int d, int c) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.c = c;
    }
}