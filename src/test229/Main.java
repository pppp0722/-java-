package test229;
// 누합,투포/백준/실버4/2003 수들의 합 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] sum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + num;
        }

        // 투포인터
        int answer = 0;
        int l = 0;
        int r = 1;
        while (l < r && r <= n) {
            int diff = sum[r] - sum[l];
            if (diff == m) {
                answer++;
            }
            if (diff > m) {
                l++;
            }
            if (diff <= m || l == r) {
                r++;
            }
        }

        System.out.println(answer);
    }
}
