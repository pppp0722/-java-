package test284;
// DFS/백준/골드5/7490 0 만들기

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            find(n, sb);
        }
        System.out.println(sb);
    }

    private static void find(int n, StringBuilder sb) {
        dfs(n, 0, new char[n - 1], sb);
        sb.append(lineSeparator());
    }

    private static void dfs(int n, int depth, char[] ops, StringBuilder sb) {
        if (depth == n - 1) {
            String exp = "1";
            for (int i = 0; i < n - 1; i++) {
                exp = exp + ops[i] + (i + 2);
            }
            if (check(exp)) {
                sb.append(exp).append(lineSeparator());
            }
            return;
        }

        ops[depth] = ' ';
        dfs(n, depth + 1, ops, sb);
        ops[depth] = '+';
        dfs(n, depth + 1, ops, sb);
        ops[depth] = '-';
        dfs(n, depth + 1, ops, sb);
    }

    private static boolean check(String exp) {
        String trimExp = exp.replace(" ", "");
        String[] nums = trimExp.split("\\+|-");
        int num = Integer.parseInt(nums[0]);
        int ct = 1;
        for (int i = 0; i < trimExp.length(); i++) {
            char c = trimExp.charAt(i);
            if (c == '+') {
                num += Integer.parseInt(nums[ct]);
                ct++;
            }
            if (c == '-') {
                num -= Integer.parseInt(nums[ct]);
                ct++;
            }
        }
        return num == 0;
    }
}
