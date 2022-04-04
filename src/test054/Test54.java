package test054;
// 프로그래머스 Level1 나머지 1이 되는 수 찾기

public class Test54 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input = 10;
		int output = sol.solution(input);
		System.out.println(output);
	}
		

}

class Solution {
    public int solution(int n) {
    	if(n % 2 == 1) return 2;
    	
    	for(int i = 3; i < n - 1; i++) {
    		if(n % i == 1) return i;
    	}
    	
    	return n - 1;
    }
}