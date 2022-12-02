package test212;
// DFS/백준/실버2/1182 부분수열의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int s;
    private static int[] arr;
    private static int answer = 0;
    private static boolean flag = false;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        s = Integer.parseInt(line[1]);
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DFS (flag는 공집합을 제외하기 위해)
        dfs(0, 0, false);

        System.out.println(answer);
    }

    private static void dfs(int depth, int sum, boolean flag) {
        if (depth == n) {
            if (flag && sum == s) {
                answer++;
            }
            return;
        }

        dfs(depth + 1, sum, flag); // 선택 X
        dfs(depth + 1, sum + arr[depth], true); // 선택 O
    }
}