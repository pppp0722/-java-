package test228;
// 그리디/백준/골드5/2212 센서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        // 간격 내림차순 k - 1개 저장
        k = Math.min(n, k);
        Arrays.sort(arr);
        int[][] diff = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            diff[i][0] = arr[i];
            diff[i][1] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff, (o1, o2) -> o2[1] - o1[1]);
        Set<Integer> skipIdx = new HashSet<>();
        for (int i = 0; i < k - 1; i++) {
            skipIdx.add(diff[i][0]);
        }

        // 그리디
        int answer = 0;
        int l = arr[0];
        int r = arr[0];
        for (int i = 0; i < n; i++) {
            r = arr[i];

            if (skipIdx.contains(r)) {
                answer += r - l;
                l = arr[i + 1];
            }
        }
        answer += r - l;

        System.out.println(answer);
    }
}