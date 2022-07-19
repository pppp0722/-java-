package test137;
// 백준/골드5/7576 토마토

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static Tomato[][] box;
    static int all;
    static int ripe;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        box = new Tomato[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 0) {
                    all++;
                } else if (type == 1) {
                    ripe++;
                    all++;
                }
                box[i][j] = new Tomato(type, i, j, 0);
            }
        }

        if (ripe == all) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Tomato> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Tomato tomato = box[i][j];
                if (tomato.type == 1) {
                    q.offer(tomato);
                }
            }
        }

        int day = -1;
        while (!q.isEmpty() && ripe < all) {
            Tomato tomato = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];

                if (isOOB(nx, ny)) {
                    continue;
                }

                Tomato nextTomato = box[nx][ny];
                if (nextTomato.type == 0) {
                    nextTomato.setType(1);
                    nextTomato.setDay(tomato.day + 1);

                    if (++ripe == all) {
                        day = nextTomato.day;
                        break;
                    }

                    q.offer(nextTomato);
                }
            }
        }

        return day;
    }

    static boolean isOOB(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return true;
        }

        return false;
    }
}

class Tomato {

    public int type;
    public int x;
    public int y;
    public int day;

    public Tomato(int type, int x, int y, int day) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.day = day;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setDay(int day) {
        this.day = day;
    }
}