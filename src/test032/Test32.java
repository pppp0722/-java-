package test032;
// 프로그래머스/Level1/짝수와 홀수
public class Test32 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input = 3;
		String output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public String solution(int num) {
        return num % 2 == 0? "Even":"Odd";
    }
}