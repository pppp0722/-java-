package test156;
// 다익/백준/골드4/4485 녹색 옷 입은 애가 젤다지?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};

    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        int idx = 1;
        while (true) {
            init();
            if (isQuit()) {
                break;
            }
            int min = findMin();
            print(idx, min);
            idx++;
        }
        BUFFERED_READER.close();
    }

    private static void init() throws IOException {
        n = Integer.parseInt(BUFFERED_READER.readLine());
        if (n != 0) {
            map = new int[n][n];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(BUFFERED_READER.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    private static boolean isQuit() {
        return n == 0;
    }

    private static int findMin() {
        Queue<Node> q = new LinkedList<>();
        int[][] lose = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(lose[i], Integer.MAX_VALUE);
        }
        lose[0][0] = map[0][0];
        q.offer(new Node(0, 0, map[0][0]));
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + DX[i];
                int ny = node.y + DY[i];
                if (isOOB(nx, ny)) {
                    continue;
                }
                int nw = node.w + map[nx][ny];
                if (nw < lose[nx][ny]) {
                    lose[nx][ny] = nw;
                    q.offer(new Node(nx, ny, nw));
                }
            }
        }
        return lose[n - 1][n - 1];
    }

    private static boolean isOOB(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    private static void print(int idx, int min) {
        System.out.println("Problem " + idx + ": " + min);
    }
}

class Node {

    public int x;
    public int y;
    public int w;

    public Node(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
}