package test019;
// 프로그래머스/Level1/문자열 다루기 기본
public class Test19 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "a234";
		boolean output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        for(int i=0; i<s.length(); i++) {
        	if(!Character.isDigit(s.charAt(i))) answer = false;
        }
        
        return s.length() == 4 || s.length() == 6? answer:false;
    }
}