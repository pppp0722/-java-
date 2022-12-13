package test231;
// 그리디/백준/실버4/2217 로프

import static java.lang.Math.max;
import static java.util.Comparator.reverseOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 그리디
        Arrays.sort(arr, reverseOrder());
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            int possibleWeight = arr[i] * (i + 1);
            maxWeight = max(possibleWeight, maxWeight);
        }

        System.out.println(maxWeight);
    }
}
