package test090;

// 프로그래머스/Level3/자물쇠와 열쇠
public class Test90 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution.solution(key, lock));
    }
}

class Solution {

    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) {
                    count++;
                }
            }
        }

        for (int degree = 0; degree < 360; degree += 90) {
            int[][] rotatedKey;
            if (degree == 0) {
                rotatedKey = key;
            } else {
                rotatedKey = rotateSquareMatrix(key, degree, M);
            }

            for (int i = 0 - M + 1; i < N; i++) {
                for (int j = 0 - M + 1; j < N; j++) {
                    int matches = 0;
                    boolean isMatch = true;
                    for (int k = 0; k < M; k++) {
                        for (int l = 0; l < M; l++) {
                            if (i + k < 0 || i + k >= N || j + l < 0 || j + l >= N) {
                                continue;
                            }
                            if (rotatedKey[k][l] == 1 && lock[i + k][j + l] == 1) {
                                isMatch = false;
                                break;
                            }
                            if (rotatedKey[k][l] == 1 && lock[i + k][j + l] == 0) {
                                matches++;
                            }
                        }
                        if (!isMatch) {
                            break;
                        }
                    }
                    if (matches == count) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public int[][] rotateSquareMatrix(int[][] matrix, int degree, int size) {
        int[][] rotatedMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (degree) {
                    case 90:
                        rotatedMatrix[i][j] = matrix[size - 1 - j][i];
                        break;
                    case 180:
                        rotatedMatrix[i][j] = matrix[size - 1 - i][size - 1 - j];
                        break;
                    case 270:
                        rotatedMatrix[i][j] = matrix[j][size - 1 - i];
                        break;
                }
            }
        }

        return rotatedMatrix;
    }
}