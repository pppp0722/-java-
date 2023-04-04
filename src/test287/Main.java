package test287;
// 수학/백준/골드4/1027 고층 건물

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 완탐
        int max = 0;
        for (int i = 0; i < n; i++) {
            int ct = 0;
            // 왼쪽
            double d = -Double.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                double curD = (double) (arr[j] - arr[i]) / (double) (i - j);
                if (curD > d) {
                    ct++;
                    d = curD;
                }
            }
            // 오른쪽
            d = -Double.MAX_VALUE;
            ;
            for (int j = i + 1; j < n; j++) {
                double curD = (double) (arr[j] - arr[i]) / (double) (j - i);
                if (curD > d) {
                    ct++;
                    d = curD;
                }
            }
            max = Math.max(ct, max);
        }

        System.out.println(max);
    }
}