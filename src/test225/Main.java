package test225;
// 그리디/백준/골드1/17420 깊콘이 넘쳐흘러

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        // 그리디
        Arrays.sort(input, (o1, o2) -> {
            // 사용할 계획 날짜 오름차순, 남은 기한 오름차순
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        long answer = 0;
        int preMax = input[0][1];
        int curMax = -1;
        for (int i = 0; i < n; i++) {
            // 현재 유효기간보다 이전 구간의 최댓값이 더 크면
            if (preMax > input[i][0]) {
                // 현재 구간 사용날짜가 이전 구간의 최댓값보다 크면 교체
                if (preMax < input[i][1]) {
                    preMax = input[i][1];
                }

                // 연장 횟수 계산
                int cnt = ((preMax - input[i][0]) + 29) / 30;
                input[i][0] += (cnt * 30);

                answer += cnt;
            }

            // 현재 구간의 최댓값 찾기
            curMax = Math.max(curMax, input[i][0]);

            // 구간 변경되면 현재 구간 최댓값을 이전 구간 최댓값으로
            if (i + 1 < n && input[i][1] != input[i + 1][1]) {
                preMax = curMax;
            }
        }

        System.out.println(answer);

        br.close();
    }
}