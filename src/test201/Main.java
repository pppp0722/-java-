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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splitLine = br.readLine().split(" ");
        int m = Integer.parseInt(splitLine[0]);
        int n = Integer.parseInt(splitLine[1]);
        int k = Integer.parseInt(splitLine[2]);
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            splitLine = br.readLine().split(" ");
            int x1 = Integer.parseInt(splitLine[0]);
            int y1 = Integer.parseInt(splitLine[1]);
            int x2 = Integer.parseInt(splitLine[2]);
            int y2 = Integer.parseInt(splitLine[3]);

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    visited[x][y] = true;
                }
            }
        }

        int numOfEmptyAreas = 0;
        List<Integer> sizesOfEmptyAreas = new ArrayList<>();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (visited[x][y]) {
                    continue;
                }

                numOfEmptyAreas++;
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{x, y});
                visited[x][y] = true;
                int sizeOfEmptyArea = 0;

                while (!q.isEmpty()) {
                    sizeOfEmptyArea++;
                    int[] cp = q.poll();
                    int cx = cp[0];
                    int cy = cp[1];

                    for (int i = 0; i < 4; i++) {
                        int nx = cx + dx[i];
                        int ny = cy + dy[i];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) {
                            continue;
                        }

                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }

                sizesOfEmptyAreas.add(sizeOfEmptyArea);
            }
        }

        Collections.sort(sizesOfEmptyAreas);
        StringBuilder sb = new StringBuilder();
        for (int sizeOfEmptyArea : sizesOfEmptyAreas) {
            sb.append(sizeOfEmptyArea).append(" ");
        }

        System.out.println(numOfEmptyAreas);
        System.out.println(sb);
    }
}
