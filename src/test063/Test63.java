package test063;

import java.util.Stack;

// 프로그래머스 Level2 짝지어 제거하기
public class Test63 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "baabaa";
		int output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
        	stack.push(s.charAt(i));
	        if (stack.size() > 1 && stack.get(stack.size() - 1) == stack.get(stack.size() - 2)) {
	        	stack.pop();
	        	stack.pop();
        	}
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}