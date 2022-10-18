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
            String[] line = br.readLine().split(" ");
            int num = Integer.parseInt(line[0]);
            int dir = Integer.parseInt(line[1]);

            rotate(dArr, num, dir);
        }

        int answer = 0;
        for (int i = 0; i < NUM_OF_GEARS; i++) {
            if (dArr[i][0] == 1) {
                answer += Math.pow(2, i);
            }
        }

        System.out.println(answer);
    }

    public static void rotate(int[][] dArr, int num, int dir) {
        int[] arr = dArr[num - 1];
        int l = arr[6];
        int r = arr[2];

        int curNum = num - 2;
        int curL = l;
        int curDir = dir;
        while (curNum >= 0) {
            int[] lArr = dArr[num - 2];

            if (curL == lArr[2]) {
                break;
            }
            curL = lArr[6];

            shift(lArr, getOppDir(curDir));
            curDir = getOppDir(curDir);
            curNum--;
        }

        curNum = num;
        int curR = r;
        curDir = dir;
        while (curNum < NUM_OF_GEARS) {
            int[] rArr = dArr[curNum];

            if (curR == rArr[6]) {
                break;
            }
            curR = rArr[2];

            shift(rArr, getOppDir(curDir));
            curDir = getOppDir(curDir);
            curNum++;
        }

        shift(arr, dir);
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

    public static int getOppDir(int dir) {
        return dir * -1;
    }
}
