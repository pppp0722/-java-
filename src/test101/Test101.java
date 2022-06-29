package test101;
// 프로그래머스/Level2/수식 최대화

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Test101 {

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        long result = new Solution().solution(expression);
        System.out.println(result);
    }
}

class Solution {

    String exp;
    long max = 0;
    String[] operators = {"+", "-", "*"};
    Map<String, Integer> priorities = new HashMap();
    boolean[] visited = new boolean[3];

    public long solution(String expression) {
        exp = expression;
        dfs(0);

        return max;
    }

    void dfs(int depth) {
        if (depth == 3) {
            calc();

            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                priorities.put(operators[depth], i);
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    void calc() {
        String num = "";
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                num += c;
            } else {
                list.add(num);
                num = "";
                while (!stack.isEmpty() && priorities.get(String.valueOf(c)) >= priorities.get(
                    stack.peek())) {
                    list.add(stack.pop());
                }
                stack.push(String.valueOf(c));
            }
        }
        list.add(num);
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        Stack<Long> stack1 = new Stack<>();
        for (String s : list) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*")) {
                stack1.push(Long.parseLong(s));
            } else {
                long num1 = stack1.pop();
                long num2 = stack1.pop();
                if (s.equals("+")) {
                    stack1.push(num2 + num1);
                } else if (s.equals("-")) {
                    stack1.push(num2 - num1);
                } else {
                    stack1.push(num2 * num1);
                }
            }
        }

        long result = Math.abs(stack1.pop());
        max = Math.max(result, max);
    }
}