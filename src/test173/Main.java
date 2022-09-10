package test173;
// 백준/골드4/14002 가장 긴 증가하는 부분 수열 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    maxLen = Math.max(dp[i], maxLen);
                }
            }
        }
        sb.append(maxLen).append("\n");

        int len = maxLen;
        Stack<Integer> stack = new Stack<>();
        for (int i = n; i > 0; i--) {
            if (dp[i] == len) {
                stack.push(arr[i]);
                len--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
