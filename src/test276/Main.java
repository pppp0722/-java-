package test276;
// 스택/백준/골드5/2493 탑

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Top> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            stack.push(new Top(i, height));
        }

        // 스택
        int[] answer = new int[n + 1];
        Stack<Top> preStack = new Stack<>();

        while (!stack.isEmpty()) {
            Top cur = stack.pop();

            while (!preStack.isEmpty() && preStack.peek().height < cur.height) {
                Top pre = preStack.pop();
                answer[pre.idx] = cur.idx;
            }

            preStack.push(cur);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}

class Top {

    public int idx;
    public int height;

    public Top(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}