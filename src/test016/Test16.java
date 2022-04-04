package test016;
// 프로그래머스/Level1/두 정수 사이의 합
public class Test16 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 3;
		int input2 = 5;
		long output = sol.solution(input1, input2);
		System.out.println(output);
	}
}

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        for(int i = a<b? a:b; i <= (a<b? b:a); i++) answer += i;
        
        return answer;
    }
}