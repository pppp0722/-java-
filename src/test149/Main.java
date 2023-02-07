package test149;
// LIS/백준/골드3/7570 줄 세우기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] arr;
    private static int[] pos;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findMin());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        pos = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pos[arr[i]] = i;
        }
        br.close();
    }

    private static int findMin() {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int len = 1;
            int val = arr[i];
            while (val < n) {
                if (pos[val + 1] < pos[val]) {
                    break;
                }
                val++;
                len++;
            }
            max = Math.max(len, max);
        }
        return n - max;
    }
}
