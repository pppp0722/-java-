package test077;

// 백준/골드5/14502번 연구소
// Backtracking
// BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int maxNumOfSafeZones = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        n = Integer.parseInt(input1[0]);
        m = Integer.parseInt(input1[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] input2 = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }

        buildWall(0);

        System.out.println(maxNumOfSafeZones);
    }

    // Backtracking
    public static void buildWall(int depth) {
        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // BFS
    public static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();

        int[][] curMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                curMap[i][j] = map[i][j];
                if (curMap[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] coordinates = queue.remove();
            int x = coordinates[0];
            int y = coordinates[1];

            if (x - 1 >= 0) { // 상
                if (curMap[x - 1][y] == 0) {
                    curMap[x - 1][y] = 2;
                    queue.add(new int[]{x - 1, y});
                }
            }
            if (x + 1 <= n - 1) { // 하
                if (curMap[x + 1][y] == 0) {
                    curMap[x + 1][y] = 2;
                    queue.add(new int[]{x + 1, y});
                }
            }
            if (y - 1 >= 0) { // 좌
                if (curMap[x][y - 1] == 0) {
                    curMap[x][y - 1] = 2;
                    queue.add(new int[]{x, y - 1});
                }
            }
            if (y + 1 <= m - 1) { // 우
                if (curMap[x][y + 1] == 0) {
                    curMap[x][y + 1] = 2;
                    queue.add(new int[]{x, y + 1});
                }
            }
        }

        countSafeZone(curMap);
    }

    public static void countSafeZone(int[][] map) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }

        if (cnt > maxNumOfSafeZones) {
            maxNumOfSafeZones = cnt;
        }
    }
}
