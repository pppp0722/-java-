package test281;
// 그리디/백준/골드5/2138 전구와 스위치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] before = br.readLine().toCharArray();
        char[] after = br.readLine().toCharArray();
        char[] startsWithSwitch = before.clone();
        change(startsWithSwitch, 0, n);

        int answer1 = 0;
        int answer2 = 1;
        for (int i = 0; i < n - 1; i++) {
            char ac = after[i];

            // 첫 스위치 X
            char bc = before[i];
            if (bc != ac) {
                change(before, i + 1, n);
                answer1++;
            }

            // 첫 스위치 O
            bc = startsWithSwitch[i];
            if (bc != ac) {
                change(startsWithSwitch, i + 1, n);
                answer2++;
            }
        }

        if (before[n - 1] == after[n - 1]) {
            System.out.println(answer1);
        } else if (startsWithSwitch[n - 1] == after[n - 1]) {
            System.out.println(answer2);
        } else {
            System.out.println(-1);
        }
    }

    private static void change(char[] arr, int idx, int maxIdx) {
        if (idx - 1 >= 0) {
            arr[idx - 1] = arr[idx - 1] == '0' ? '1' : '0';
        }
        arr[idx] = arr[idx] == '0' ? '1' : '0';
        if (idx + 1 < maxIdx) {
            arr[idx + 1] = arr[idx + 1] == '0' ? '1' : '0';
        }
    }
}
