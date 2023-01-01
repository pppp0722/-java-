package test085;

// DFS,미니맥스/프로그래머스/Level3/사라지는 발판

class Solution {

    private final int[] DX = {-1, 0, 1, 0};
    private final int[] DY = {0, 1, 0, -1};
    private int[][] board;
    private int n;
    private int m;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
    }

    public int dfs(int px, int py, int ox, int oy) {
        if (isLandless(px, py)) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            int nx = px + DX[i];
            int ny = py + DY[i];
            if (isOOB(nx, ny) || isLandless(nx, ny)) {
                continue;
            }
            board[px][py] = 0;
            int val = dfs(ox, oy, nx, ny) + 1;
            board[px][py] = 1;
            if (ret % 2 == 0 && val % 2 == 1) {
                ret = val;
            } else if (ret % 2 == 1 && val % 2 == 1) {
                ret = Math.min(val, ret);
            } else if (ret % 2 == 0 && val % 2 == 0) {
                ret = Math.max(val, ret);
            }
        }
        return ret;
    }

    private boolean isOOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    private boolean isLandless(int x, int y) {
        return board[x][y] == 0;
    }
}

public class Test85 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[] aloc = {1, 0};
        int[] bloc = {1, 2};
        int answer = solution.solution(board, aloc, bloc);
        System.out.println(answer);
    }
}