package test035;
// 프로그래머스/Level1/평균 구하기

public class Test35 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input = {1,2,3,4};
		double output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public double solution(int[] arr) {
        double sum = 0.0;
        
        for(int i : arr) sum+=i;
        
        return sum/arr.length;
    }
}