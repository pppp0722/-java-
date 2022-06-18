package test098;
// 백준/골드5/2110번 공유기 설치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int C;
    static int[] houseXs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        N = size[0];
        C = size[1];
        houseXs = new int[N];
        for (int i = 0; i < N; i++) {
            houseXs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houseXs);

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int l = 1;
        int r = houseXs[N - 1] - houseXs[0];
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (isPossible(m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (isPossible(r)) {
            r++;
        }

        return r - 1;
    }

    public static boolean isPossible(int length) {
        int ct = 1;
        int lastX = houseXs[0];
        for (int i = 1; i < N; i++) {
            int curX = houseXs[i];

            if (curX - lastX < length) {
                continue;
            }

            ct++;
            if (ct == C) {
                return true;
            }

            lastX = curX;
        }

        return false;
    }
}
