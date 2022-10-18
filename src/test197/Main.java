package test197;
// 백준/골드5/14891 톱니바퀴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int NUM_OF_GEARS = 4;
    public static final int NUM_OF_SAWS = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dArr = new int[NUM_OF_GEARS][NUM_OF_SAWS];
        for (int i = 0; i < NUM_OF_GEARS; i++) {
            String line = br.readLine();
            for (int j = 0; j < NUM_OF_SAWS; j++) {
                dArr[i][j] = line.charAt(j) == '1' ? 1 : -1;
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] split = br.readLine().split(" ");
            int num = Integer.parseInt(split[0]) - 1;
            int dir = Integer.parseInt(split[1]);

            operate(dArr, num, dir);
        }

        System.out.println(getAnswer(dArr));
    }

    public static void operate(int[][] dArr, int num, int dir) {
        leftRotate(dArr, num - 1, -dir);
        rightRotate(dArr, num + 1, -dir);
        shift(dArr[num], dir);
    }

    public static void leftRotate(int[][] dArr, int num, int dir) {
        if (num < 0 || dArr[num][2] == dArr[num + 1][6]) {
            return;
        }

        leftRotate(dArr, num - 1, -dir);
        shift(dArr[num], dir);
    }

    public static void rightRotate(int[][] dArr, int num, int dir) {
        if (num >= NUM_OF_GEARS || dArr[num][6] == dArr[num - 1][2]) {
            return;
        }

        rightRotate(dArr, num + 1, -dir);
        shift(dArr[num], dir);
    }

    public static void shift(int[] arr, int dir) {
        if (dir == 1) {
            int tmp = arr[NUM_OF_SAWS - 1];
            for (int i = NUM_OF_SAWS - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = tmp;
        } else {
            int tmp = arr[0];
            for (int i = 1; i < NUM_OF_SAWS; i++) {
                arr[i - 1] = arr[i];
            }
            arr[NUM_OF_SAWS - 1] = tmp;
        }
    }

    public static int getAnswer(int[][] dArr) {
        int answer = 0;
        for (int i = 0; i < NUM_OF_GEARS; i++) {
            if (dArr[i][0] == 1) {
                answer += Math.pow(2, i);
            }
        }

        return answer;
    }
}
