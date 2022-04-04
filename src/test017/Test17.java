package test017;
// 프로그래머스/Level1/문자열 내 p와 y의 개수
public class Test17 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "pPoooyY";
		boolean output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    boolean solution(String s) {
        int ct = 0;
        
        for(int i=0; i<s.length(); i++) {
        	char ch = s.charAt(i);
        	if(ch == 'p' || ch == 'P') ct++;
        	else if(ch == 'y' || ch == 'Y') ct--;
        }
        
        return ct == 0;
    }
}