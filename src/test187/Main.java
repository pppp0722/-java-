package test187;
// 구현/백준/골드3/14890 경사로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int l;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findNumOfPassableRoads());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int findNumOfPassableRoads() {
        int numOfPassableRoads = 0;
        for (int i = 0; i < n; i++) {
            if (canPass(i, Direction.HORIZONTAL)) {
                numOfPassableRoads++;
                System.out.println("수평" + i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (canPass(i, Direction.VERTICAL)) {
                numOfPassableRoads++;
                System.out.println("수직" + i);
            }
        }
        return numOfPassableRoads;
    }

    private static boolean canPass(int idx, Direction direction) {
        int[] arr;
        if (direction == Direction.HORIZONTAL) {
            arr = map[idx];
        } else {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = map[i][idx];
            }
        }
        return canPass(arr);
    }

    private static boolean canPass(int[] arr) {
        boolean canPass = true;
        int[] support = new int[n];
        int h = arr[0];
        for (int i = 1; i < n; i++) {
        }
        return canPass;
    }
}

enum Direction {
    HORIZONTAL, VERTICAL
}