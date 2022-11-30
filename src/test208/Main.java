package test208;
// 백트래킹/백준/실버3/15649 N과 M (1)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static int n;
    private static int m;
    private static int[] arr;
    private static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        arr = new int[m];
        set = new HashSet<>();

        // 백트래킹
        backtrack(0);
    }

    public static void backtrack(int depth) {
        if (depth == m) {
            print();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }

            set.add(i);
            arr[depth] = i;
            backtrack(depth + 1);
            set.remove(i);
        }
    }

    public static void print() {
        for (int i = 0; i < m; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}