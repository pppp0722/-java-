package test008;
// 프로그래머스/Level1/약수의 개수와 덧셈
public class Test8 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 13;
		int input2 = 17;
		int output = sol.solution(input1, input2);
		System.out.println(output);
	}
}

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<right+1; i++) {
        	int ct = 0;
        	for(int j=1; j<=i; j++) {
        		if(i % j == 0) ct++;
        	}
        	if(ct%2 == 0) answer += i;
        	else answer -= i;
        }
        
        return answer;
    }
}