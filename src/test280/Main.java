package test280;
// 투포인터/백준/골드5/2467 용액

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // O(N) - 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // O(N) - 투포인터
        int minDiff = Integer.MAX_VALUE;
        int idx1 = 0;
        int idx2 = n - 1;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            int diff = Math.abs(sum);

            if (diff < minDiff) {
                idx1 = l;
                idx2 = r;
                minDiff = diff;
            }

            if(sum == 0) {
                break;
            } else if(sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(arr[idx1] + " " + arr[idx2]);
    }
}
