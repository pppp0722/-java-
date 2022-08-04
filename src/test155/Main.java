package test155;
// 백준/골드5/13549 숨바꼭질 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static final int MAX = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        boolean[] visited = new boolean[MAX + 1];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(N, 0));

        int answer = -1;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int x = p.getX();
            int time = p.getTime();

            visited[x] = true;

            if (x == K) {
                answer = time;
                break;
            }

            if (x != 0 && 2 * x <= MAX && !visited[2 * x]) {
                q.offer(new Point(2 * x, time));
            }
            if (x - 1 >= 0 && !visited[x - 1]) {
                q.offer(new Point(x - 1, time + 1));
            }
            if (x + 1 <= MAX && !visited[x + 1]) {
                q.offer(new Point(x + 1, time + 1));
            }
        }

        System.out.println(answer);
    }
}

class Point {

    private int x;
    private int time;

    public Point(int x, int time) {
        this.x = x;
        this.time = time;
    }

    public int getX() {
        return x;
    }

    public int getTime() {
        return time;
    }
}