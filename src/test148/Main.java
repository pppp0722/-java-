package test148;
// 백준/골드3/1644 소수의 연속합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> primeNums = getPrimeNums(N);
        int[] arr = new int[primeNums.size()];
        int sum = 0;
        for (int i = 0; i < primeNums.size(); i++) {
            sum += primeNums.get(i);
            arr[i] = sum;
        }

        int l = -1;
        int r = 0;
        int answer = 0;
        while (r < arr.length) {
            int num1 = l == -1 ? 0 : arr[l];
            int num2 = arr[r];
            int diff = num2 - num1;
            if (diff == N) {
                answer++;
                r++;
            } else if (diff < N) {
                r++;
            } else {
                if (l + 1 == r) {
                    r++;
                } else {
                    l++;
                }
            }
        }

        System.out.println(answer);
    }

    static List<Integer> getPrimeNums(int max) {
        if (max <= 1) {
            return Collections.emptyList();
        }

        boolean[] isPrimeNum = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrimeNum[i] = true;
        }

        for (int i = 2; i * i <= max; i++) {
            if (isPrimeNum[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrimeNum[j] = false;
                }
            }
        }

        List<Integer> primeNums = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrimeNum[i]) {
                primeNums.add(i);
            }
        }

        return primeNums;
    }
}
