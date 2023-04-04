package test286;
// 유니온파인드/백준/골드4/1976 여행 가자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if ("1".equals(st.nextToken())) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int root = find(Integer.parseInt(st.nextToken()));
        String answer = "YES";
        for (int i = 1; i < m; i++) {
            int curRoot = find(Integer.parseInt(st.nextToken()));
            if (root != curRoot) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }

    private static void union(int n1, int n2) {
        n1 = find(n1);
        n2 = find(n2);
        arr[n1] = n2;
    }

    private static int find(int n) {
        if (arr[n] == n) {
            return n;
        }
        return arr[n] = find(arr[n]);
    }
}
