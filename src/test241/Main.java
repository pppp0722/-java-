package test241;
// 백트래킹/백준/골드3/15684 사다리 조작

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int h;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        int answer = -1;
        for (int i = 0; i <= 3; i++) {
            if (backtrack(i, 0, -1)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[n + 1][h + 1];
        int a;
        int b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map[b][a] = 1;
            map[b + 1][a] = 2;
        }
        br.close();
    }

    private static boolean backtrack(int maxDepth, int depth, int lastIdx) {
        if (check()) {
            return true;
        }

        if (depth == maxDepth) {
            return false;
        }

        boolean ret = false;
        int x;
        int y;
        for (int i = lastIdx + 1; i < (n - 1) * h; i++) {
            x = i / h + 1;
            y = i % h + 1;

            if (map[x][y] != 0 || map[x + 1][y] != 0) {
                continue;
            }

            map[x][y] = 1;
            map[x + 1][y] = 2;
            if (backtrack(maxDepth, depth + 1, i)) {
                ret = true;
            }
            map[x][y] = 0;
            map[x + 1][y] = 0;
        }
        return ret;
    }

    private static boolean check() {
        int idx;
        for (int i = 1; i <= n; i++) {
            idx = i;
            for (int j = 1; j <= h; j++) {
                if (map[idx][j] == 1) {
                    idx++;
                } else if (map[idx][j] == 2) {
                    idx--;
                }
            }
            if (idx != i) {
                return false;
            }
        }
        return true;
    }
}