package test023;
// 프로그래머스/Level1/문자열을 정수로 바꾸기

public class Test23 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "1234";
		int output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public int solution(String s) {
        return Integer.parseInt(s);
    }
}
