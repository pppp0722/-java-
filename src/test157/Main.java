package test157;
// 백준/골드4/1253 좋다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Arrays.sort(arr);

        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            boolean isGoodNum = false;
            for (int j = n - 1; j >= 0; j--) {
                int key = num - arr[j];
                int l = 0;
                int r = j - 1;
                if (j == i) {
                    continue;
                }
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (arr[mid] > key) {
                        r = mid - 1;
                    } else if (arr[mid] == key && mid != i && mid != j) {
                        isGoodNum = true;
                        break;
                    } else {
                        l = mid + 1;
                    }
                }

            }
            if (isGoodNum) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}