package test168;
// 백준/골드3/18808 스티커 붙이기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Notebook {

    public int rowLen;
    public int colLen;
    public boolean[][] isFilled;

    public Notebook(int rowLen, int colLen) {
        this.rowLen = rowLen;
        this.colLen = colLen;
        this.isFilled = new boolean[rowLen][colLen];
    }

    public boolean isPossible(int x, int y, Sticker sticker) {
        for (int i = 0; i < sticker.rowLen; i++) {
            for (int j = 0; j < sticker.colLen; j++) {
                if (sticker.matrix[i][j] == 1 && isFilled[i + x][j + y]) {
                    return false;
                }
            }
        }

        return true;
    }

    public int stick(int x, int y, Sticker sticker) {
        for (int i = 0; i < sticker.rowLen; i++) {
            for (int j = 0; j < sticker.colLen; j++) {
                if (sticker.matrix[i][j] == 1) {
                    this.isFilled[i + x][j + y] = true;
                }
            }
        }

        return sticker.num;
    }
}

class Sticker {

    int num;
    int rowLen;
    int colLen;
    int[][] matrix;

    public Sticker(int[][] matrix, int num) {
        this.num = num;
        this.matrix = matrix;
        this.rowLen = matrix.length;
        this.colLen = matrix[0].length;
    }

    public Sticker rotate() {
        int[][] rotatedMatrix = new int[this.matrix[0].length][this.matrix.length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                rotatedMatrix[j][rowLen - i - 1] = this.matrix[i][j];
            }
        }

        return new Sticker(rotatedMatrix, this.num);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);
        Notebook notebook = new Notebook(N, M);
        int answer = 0;
        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            int R = Integer.parseInt(line[0]);
            int C = Integer.parseInt(line[1]);
            int[][] matrix = new int[R][C];
            int num = 0;
            for (int j = 0; j < R; j++) {
                int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
                for (int k = 0; k < C; k++) {
                    if (row[k] == 1) {
                        num++;
                    }
                }
                matrix[j] = row;
            }
            Sticker sticker = new Sticker(matrix, num);
            for (int j = 0; j < 4; j++) {
                boolean isStick = false;
                for (int k = 0; k <= notebook.rowLen - sticker.rowLen; k++) {
                    for (int l = 0; l <= notebook.colLen - sticker.colLen; l++) {
                        if (notebook.isPossible(k, l, sticker)) {
                            answer += notebook.stick(k, l, sticker);
                            isStick = true;
                            break;
                        }
                    }
                    if (isStick) {
                        break;
                    }
                }
                if (isStick) {
                    break;
                }

                sticker = sticker.rotate();
            }
        }

        System.out.println(answer);
    }
}
