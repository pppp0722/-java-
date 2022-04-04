package test027;
// 프로그래머스/Level1/자릿수 더하기

public class Test27 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input = 123;
		int output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n>0) {
        	answer += n%10;
        	n /= 10;
        }
        
        return answer;
    }
}