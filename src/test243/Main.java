package test243;
// 백트래킹/백준/실버2/15663 N과 M (9)

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[] arr;
    private static boolean[] visited;
    private static int[] selected;
    private static Set<String> set;

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(arr);
        backtrack(0);
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        set = new LinkedHashSet<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        selected = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    private static void backtrack(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : selected) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            selected[depth] = arr[i];
            visited[i] = true;
            backtrack(depth + 1);
            visited[i] = false;
        }
    }

    private static void printAnswer() {
        StringBuilder answer = new StringBuilder();
        for (String s : set) {
            answer.append(s).append(lineSeparator());
        }
        System.out.println(answer);
    }
}
