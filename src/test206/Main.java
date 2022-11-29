package test206;
// 그리디/백준/골드5/2170 선 긋기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            points[i] = new int[]{x, y};
        }

        // 그리디를 위한 정렬 (x 오름차순 먼저, y 오름차순)
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        // 그리디
        int lastX = points[0][0];
        int lastY = points[0][1];
        int totalLen = lastY - lastX;
        for (int i = 1; i < n; i++) {
            int curX = points[i][0];
            int curY = points[i][1];

            if (curX >= lastX && curY <= lastY) {
                continue;
            } else if (curX >= lastY) {
                totalLen += curY - curX;
            } else {
                totalLen += curY - lastY;
            }

            lastX = curX;
            lastY = curY;
        }

        System.out.println(totalLen);
    }
}
