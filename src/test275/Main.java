package test275;
// BFS/백준/골드5/16234 인구 이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS
        int answer = 0;
        while (true) {
            boolean[][] visited = new boolean[n][n];
            boolean check = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        continue;
                    }

                    int num = map[i][j];
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        int x = pos[0];
                        int y = pos[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + DX[k];
                            int ny = y + DY[k];

                            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                                continue;
                            }

                            if (Math.abs(map[x][y] - map[nx][ny]) < l
                                || Math.abs(map[x][y] - map[nx][ny]) > r) {
                                continue;
                            }

                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;

                            num += map[nx][ny];
                            stack.push(new int[]{nx, ny});
                        }
                    }

                    int size = stack.size();

                    if (size > 1) {
                        check = true;
                    }

                    while (!stack.isEmpty()) {
                        int[] pos = stack.pop();
                        map[pos[0]][pos[1]] = num / size;
                    }
                }
            }

            if (!check) {
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }
}
