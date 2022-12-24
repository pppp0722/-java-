package test242;
// 시뮬/백준/골드3/16236 아기 상어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static int n;
    private static int[][] map;
    private static int x;
    private static int y;
    private static int size;
    private static int ct;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findMaxTime());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        size = 2;
        ct = 0;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int size = Integer.parseInt(st.nextToken());
                if (size == 9) {
                    x = i;
                    y = j;
                    map[i][j] = 0;
                } else {
                    map[i][j] = size;
                }
            }
        }
        br.close();
    }

    private static int findMaxTime() {
        int time = 0;
        while (true) {
            int move = eat();
            if (move == 0) {
                break;
            }
            if (++ct == size) {
                size++;
                ct = 0;
            }
            time += move;
        }
        return time;
    }

    private static int eat() {
        int move = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] == o2[2]) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
            return o1[2] - o2[2];
        });
        q.offer(new int[]{x, y, 0});
        boolean[][] visited = new boolean[n][n];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cm = cur[2];
            int cs = map[cx][cy];

            if (cs > 0 && cs < size) {
                map[cx][cy] = 0;
                move = cm;
                x = cx;
                y = cy;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + DX[i];
                int ny = cy + DY[i];

                if (isOOB(nx, ny) || visited[nx][ny] || map[nx][ny] > size) {
                    continue;
                }

                q.offer(new int[]{nx, ny, cm + 1});
                visited[nx][ny] = true;
            }
        }
        return move;
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}