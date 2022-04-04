package test022;
// 프로그래머스/Level1/수박수박수박수박수박수?
public class Test22 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input = 3;
		String output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public String solution(int n) {
        String answer = "";
        
        for(int i=0; i<n; i++) answer += i%2 == 0 ? "수" : "박";
        
        return answer;
    }
}