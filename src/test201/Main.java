package test201;
// 백준/실버1/2583 영역 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    // 2개
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int m = Integer.parseInt(line[0]); // row 수
        int n = Integer.parseInt(line[1]); // column 수
        int k = Integer.parseInt(line[2]); // 사각형 수
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            line = br.readLine().split(" ");
            int y1 = Integer.parseInt(line[0]);
            int x1 = Integer.parseInt(line[1]);
            int y2 = Integer.parseInt(line[2]);
            int x2 = Integer.parseInt(line[3]);
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    visited[x][y] = true;
                }
            }
        }

        int answer1 = 0;
        List<Integer> answer2 = new ArrayList<>();

        for (int y = 0; y < n; y++) {
            for (int x = m - 1; x >= 0; x--) {
                if (visited[x][y]) {
                    continue;
                }

                answer1++;
                int ct = 0;

                Queue<Point> q = new LinkedList<>();
                q.offer(new Point(x, y));
                visited[x][y] = true;

                while (!q.isEmpty()) {
                    Point cp = q.poll();
                    ct++;

                    for (int i = 0; i < 4; i++) {
                        int nx = cp.x + dx[i];
                        int ny = cp.y + dy[i];

                        if (nx < 0 || nx >= m || ny < 0 || ny >= n
                            || visited[nx][ny]) {
                            continue;
                        }

                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }

                answer2.add(ct);
            }
        }

        System.out.println(answer1);
        Collections.sort(answer2);
        for (int i : answer2) {
            System.out.print(i + " ");
        }
    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}