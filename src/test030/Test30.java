package test030;
// 프로그래머스/Level1/정수 제곱근 판별
public class Test30 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		long input = 121;
		long output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public long solution(long n) {
    	double d = Math.pow(n, 0.5);
    	
        return (d % 1) == 0 ? (long)((d+1)*(d+1)) : -1;
    }
}