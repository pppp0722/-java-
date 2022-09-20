package test186;
// 백준/골드2/12015 가장 긴 증가하는 부분 수열 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 1;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[n + 1];
        int len = 1;
        lis[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            if (arr[i] > lis[len]) {
                lis[++len] = arr[i];
            } else {
                int l = 1;
                int r = len;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (arr[i] > lis[m]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                lis[l] = arr[i];
            }
        }

        System.out.println(len);
    }
}
