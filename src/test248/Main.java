package test248;
// 스택/백준/플레5/6549 히스토그램에서 가장 큰 직사각형

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n,  mid, left;
        int[] heights;
        long answer;
        Stack<Integer> stack;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            heights = new int[n + 1];
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            heights[n] = -1;
            stack = new Stack<>();
            stack.push(-1);
            answer = 0;
            for (int i = 0; i < heights.length; i++) {
                while (stack.size() > 1 && heights[i] < heights[stack.peek()]) {
                    mid = stack.pop();
                    left = stack.peek();
                    answer = Math.max(answer, (long) (i - left - 1) * heights[mid]);
                }
                stack.push(i);
            }
            sb.append(answer).append(lineSeparator());
        }

        System.out.println(sb);
    }
}
