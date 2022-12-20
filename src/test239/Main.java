package test239;
// 그리디/백준/골드3/3165 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()) + 1;
        int k = Integer.parseInt(st.nextToken());

        // 현재 숫자 5 개수 계산
        int fiveCt = 0;
        long n1 = n;
        while (n1 > 0) {
            if (n1 % 10 == 5) {
                fiveCt++;
            }
            n1 /= 10;
        }

        // 일의 자리수부터 그리디
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        long n2 = n;
        while (n2 > 0) {
            long cur = n2 % 10;
            if (fiveCt < k) {
                if (cur < 5) {
                    cur = 5;
                    fiveCt++;
                }
                if (cur > 5) {
                    long n3 = n2 / 10;
                    if (n3 % 10 == 4 && fiveCt == k - 1) {
                        cur = 0;
                    } else {
                        cur = 5;
                        fiveCt++;
                    }
                    while ((n3 % 10) == 9) {
                        n3 /= 10;
                    }
                    if (n3 % 10 == 4) {
                        fiveCt++;
                    }
                    if (n3 % 10 == 5) {
                        fiveCt--;
                    }
                    n2 += 10;
                }
            }
            stack.push(String.valueOf(cur));
            n2 /= 10;
        }
        for (int i = fiveCt; i < k; i++) {
            stack.push("5");
        }

        // 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}