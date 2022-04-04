package test034;
// 프로그래머스/Level1/콜라츠 추측

public class Test34 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input = 6;
		int output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public int solution(int num) {
    	long n = num;
    	
        for(int i=0; i<500; i++) {
        	if(n == 1) return i;
        	else if(n%2 == 0) n /= 2;
        	else n = 3*n + 1;
        }
        
        return -1;
    }
}