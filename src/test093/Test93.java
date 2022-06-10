package test093;
// 프로그래머스/Level2/행렬 테두리 회전하기
import java.util.LinkedList;
import java.util.Queue;

public class Test93 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] answer = solution.solution(rows, columns, queries);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}

class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = rotate(matrix, queries[i]);
        }
        return answer;
    }

    public int rotate(int[][] matrix, int[] query) {
        Queue<Integer> queue = new LinkedList<>();
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        for (int y = y1; y < y2; y++) {
            queue.add(matrix[x1][y]);
        }
        for (int x = x1; x < x2; x++) {
            queue.add(matrix[x][y2]);
        }
        for (int y = y2; y > y1; y--) {
            queue.add(matrix[x2][y]);
        }
        for (int x = x2; x > x1; x--) {
            queue.add(matrix[x][y1]);
        }

        int min = queue.stream()
            .min(Integer::compare)
            .get();

        for (int y = y1 + 1; y <= y2; y++) {
            matrix[x1][y] = queue.remove();
        }
        for (int x = x1 + 1; x <= x2; x++) {
            matrix[x][y2] = queue.remove();
        }
        for (int y = y2 - 1; y >= y1; y--) {
            matrix[x2][y] = queue.remove();
        }
        for (int x = x2 - 1; x >= x1; x--) {
            matrix[x][y1] = queue.remove();
        }

        return min;
    }
}