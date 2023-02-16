package test185;
// 스택/백준/골드4/9935 문자열 폭발

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static String str;
    private static String explosionStr;

    public static void main(String[] args) throws IOException {
        init();
        print(getExplodedStr());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        explosionStr = br.readLine();
        br.close();
    }

    private static String getExplodedStr() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);
            if (stack.size() >= explosionStr.length()) {
                explode(stack);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private static void explode(Stack<Character> stack) {
        Stack<Character> tmpStack = new Stack<>();
        boolean check = true;
        for (int i = 0; i < explosionStr.length(); i++) {
            if (stack.peek() != explosionStr.charAt(explosionStr.length() - i - 1)) {
                check = false;
                break;
            }
            tmpStack.push(stack.pop());
        }
        if (!check) {
            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }
        }
    }

    private static void print(String str) {
        System.out.println("".equals(str) ? "FRULA" : str);
    }
}
