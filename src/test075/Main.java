package test075;

// 백준/3등급/10974번 모든순열
// Backtracking

import java.util.Scanner;

public class Main {

    static int length;
    static int[] numArr;
    static boolean[] visited;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        length = scanner.nextInt();
        visited = new boolean[length];
        numArr = new int[length];

        backtracking(0);
        System.out.print(stringBuilder.toString());
    }

    public static void backtracking(int depth) {
        if(depth == length) {
            for(int num : numArr)
                stringBuilder.append(num + " ");
            stringBuilder.append("\n");

            return;
        }

        for(int i = 0; i < length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            numArr[depth] = i + 1;
            backtracking(depth + 1);
            visited[i] = false;
        }
    }
}