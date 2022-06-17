package test095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준/실버1/14888번 연산자 끼워넣기
public class Main {

    static int N;
    static int[] nums;
    static int[] opNums;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        opNums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        dfs(nums[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int num, int depth) {
        if (depth == N) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            return;
        }
        for (int i = 0; i < opNums.length; i++) {
            if (opNums[i] > 0) {
                opNums[i]--;
                int operand = nums[depth];
                int nextNum;
                if (i == 0) {
                    nextNum = num + operand;
                } else if (i == 1) {
                    nextNum = num - operand;
                } else if (i == 2) {
                    nextNum = num * operand;
                } else {
                    nextNum = num / operand;
                }
                dfs(nextNum, depth + 1);
                opNums[i]++;
            }
        }
    }
}
