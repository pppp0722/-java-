package test146;
// 투포/백준/골드5/2230 수 고르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findMinDiff());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    private static int findMinDiff() {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int l = 0;
        int r = 1;
        while (l < n - 1 && r < n) {
            int diff = arr[r] - arr[l];
            if (diff < m) {
                r++;
            } else {
                minDiff = Math.min(diff, minDiff);
                if (l + 1 == r) {
                    r++;
                } else {
                    l++;
                }
            }
        }
        return minDiff;
    }
}