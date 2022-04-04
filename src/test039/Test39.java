package test039;
// 프로그래머스/Level1/x만큼 간격이 있는 n개의 숫자
public class Test39 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 1000000;
		int input2 = 1000;
		long[] output = sol.solution(input1, input2);
		for(long l : output) System.out.println(l);
	}
}

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long l = x;
        
        for(int i=0; i<n; i++) answer[i] = (i+1)*l;
        
        return answer;
    }
}