package test277;
// 구현/백준/골드5/14719 빗물

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // O(N) - 초기화 및 해당 인덱스 포함 좌측 최대 높이 계산
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] heights = new int[w];
        int[] leftMaxHeights = new int[w];
        int maxHeight = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int height = Integer.parseInt(st.nextToken());
            heights[i] = height;
            maxHeight = Math.max(height, maxHeight);
            leftMaxHeights[i] = maxHeight;
        }

        // O(N) - 해당 인덱스 포함 우측 최대 높이 계산
        int[] rightMaxHeights = new int[w];
        maxHeight = 0;
        for (int i = w - 1; i >= 0; i--) {
            int height = heights[i];
            maxHeight = Math.max(height, maxHeight);
            rightMaxHeights[i] = maxHeight;
        }

        // O(N) - 빗물 양 계산
        int answer = 0;
        for (int i = 1; i < w - 1; i++) {
            int height = heights[i];
            int bothMaxHeight = Math.min(leftMaxHeights[i], rightMaxHeights[i]);
            if (bothMaxHeight > height) {
                answer += bothMaxHeight - height;
            }
        }

        System.out.println(answer);
    }
}