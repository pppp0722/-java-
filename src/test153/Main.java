package test153;
// 백준/골드5/15686 치킨배달

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static List<Position> homes = new ArrayList<>();
    static List<Position> restaurants = new ArrayList<>();
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int spot = Integer.parseInt(line[j]);
                map[i][j] = spot;
                if (spot == 1) {
                    homes.add(new Position(i, j));
                } else if (spot == 2) {
                    restaurants.add(new Position(i, j));
                }
            }
        }

        dfs(0, -1);

        System.out.println(answer);
    }

    static void dfs(int depth, int idx) {
        if (depth == restaurants.size() - M) {
            bfs();
            return;
        }

        for (int i = idx + 1; i < restaurants.size(); i++) {
            Position restaurant = restaurants.get(i);
            map[restaurant.getX()][restaurant.getY()] = 0;
            dfs(depth + 1, i);
            map[restaurant.getX()][restaurant.getY()] = 2;
        }
    }

    static void bfs() {
        int totalDistance = 0;

        for (int i = 0; i < homes.size(); i++) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            Position home = homes.get(i);
            visited[home.getX()][home.getY()] = true;
            q.offer(new int[]{home.getX(), home.getY(), 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];
                int distance = cur[2];

                if (map[cx][cy] == 2) {
                    totalDistance += distance;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];

                    if (!isOOB(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, distance + 1});
                    }
                }
            }
        }

        answer = Math.min(totalDistance, answer);
    }

    static boolean isOOB(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return true;
        }

        return false;
    }
}

class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
