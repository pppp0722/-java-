package test108;
// 프로그래머스/Level3/정수 삼각형

class Solution {

    public int solution(int[][] triangle) {
        int[] row = triangle[0];
        for (int i = 0; i < triangle.length - 1; i++) {
            triangle[i] = row;
            row = sum(triangle, i);
        }

        int max = row[0];
        for (int i = 1; i < row.length; i++) {
            if (row[i] > max) {
                max = row[i];
            }
        }

        return max;
    }

    int[] sum(int[][] triangle, int index) {
        int[] nextRow = new int[index + 2];
        for (int i = 0; i <= index; i++) {
            nextRow[i] = triangle[index][i] + triangle[index + 1][i];
        }

        for (int i = 0; i <= index; i++) {
            nextRow[i + 1] = Math.max(
                triangle[index][i] + triangle[index + 1][i + 1],
                nextRow[i + 1]
            );
        }

        return nextRow;
    }
}

public class Test108 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = new Solution().solution(triangle);
        System.out.println(result);
    }
}