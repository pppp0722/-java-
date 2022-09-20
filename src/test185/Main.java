package test185;
// 백준/골드4/9935 문자열 폭발

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String key = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= key.length()) {
                int matches = 0;
                for (int j = 0; j < key.length(); j++) {
                    if (stack.get(stack.size() - j - 1) == key.charAt(key.length() - j - 1)) {
                        matches++;
                    } else {
                        break;
                    }
                }
                if (matches == key.length()) {
                    for (int j = 0; j < key.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.reverse().toString());
    }
}
