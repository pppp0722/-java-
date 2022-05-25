package test084;
// 프로그래머스/Level3/파괴되지 않은 건물
public class Test84 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2},
            {1, 0, 1, 3, 3, 1}};
        long answer = solution.solution(board, skill);
        System.out.println(answer);
    }
}

class Solution {

    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        int[][] sum = new int[N + 1][M + 1];
        for (int[] info : skill) {
            int y1 = info[1];
            int x1 = info[2];
            int y2 = info[3];
            int x2 = info[4];
            int power = info[5] * (info[0] == 1 ? -1 : 1);

            sum[y1][x1] += power;
            sum[y1][x2 + 1] += power * -1;
            sum[y2 + 1][x1] += power * -1;
            sum[y2 + 1][x2 + 1] += power;
        }

        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
                sum[y][x] += sum[y - 1][x];
            }
        }

        for (int x = 1; x < M; x++) {
            for (int y = 0; y < N; y++) {
                sum[y][x] += sum[y][x - 1];
            }
        }

        int answer = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (board[y][x] + sum[y][x] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}