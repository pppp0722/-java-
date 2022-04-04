package test059;
// 프로그래머스 Level2 124 나라의 숫자
public class Test59 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input = 3;
		String output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public String solution(int n) {
    	String s = "";
    	
    	while(n > 0) {
    		int r = n % 3;
    		
    		if(r == 0) {
    			n = n / 3 - 1;
    			r = 4;
    		}else {
    			n /= 3;
    		}
    		
    		s = String.valueOf(r) + s;
    	}
        return s;
    }
}