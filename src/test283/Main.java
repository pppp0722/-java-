package test283;
// 사이클/백준/골드5/2668 숫자고르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int[] arr;
    private static boolean[] visited;
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // DFS
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, new ArrayList<>());
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }

    private static void dfs(int idx, List<Integer> list) {
        visited[idx] = true;
        list.add(idx);
        int nextIdx = arr[idx];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == nextIdx) {
                answer.addAll(list.subList(i, list.size()));
                return;
            }
        }
        if(!visited[nextIdx]) {
            dfs(nextIdx, list);
        }
    }
}