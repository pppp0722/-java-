package test036;
// 프로그래머스/Level1/하샤드 수

public class Test36 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input = 11;
		boolean output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public boolean solution(int x) {
    	int num = x;
    	int sum = 0;
    	while(num>0) {
    		sum += num%10;
    		num /= 10;
    	}
    	
        return x % sum == 0? true : false;
    }
}