package test156;
// 백준/골드4/4485 녹색 옷 입은 애가 젤다지?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            }

            int[][] lose = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    lose[i][j] = Integer.MAX_VALUE;
                }
            }
            lose[0][0] = map[0][0];
            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(0, 0, map[0][0]));

            while (!q.isEmpty()) {
                Point cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.getX() + dx[i];
                    int ny = cur.getY() + dy[i];

                    if (isOOB(N, nx, ny)) {
                        continue;
                    }

                    int nLose = cur.getLose() + map[nx][ny];
                    if (nLose < lose[nx][ny]) {
                        lose[nx][ny] = nLose;
                        q.offer(new Point(nx, ny, nLose));
                    }
                }
            }

            System.out.println("Problem " + idx + ": " + lose[N - 1][N - 1]);
            idx++;
        }
    }

    private static boolean isOOB(int N, int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return true;
        }

        return false;
    }
}

class Point {

    private int x;
    private int y;
    private int lose;

    public Point(int x, int y, int lose) {
        this.x = x;
        this.y = y;
        this.lose = lose;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLose() {
        return lose;
    }
}
