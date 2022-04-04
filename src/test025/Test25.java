package test025;
// 프로그래머스/Level1/약수의 합

public class Test25 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 12;
		int output = sol.solution(input1);
		System.out.println(output);
	}
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n/2; i++) {
        	if(n%i == 0) answer += i;
        }
        
        return answer+n;
    }
}