package test026;
// 프로그래머스/Level1/이상한 문자 만들기
public class Test26 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "try hello world";
		String output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int ct = 0;
        for(int i=0; i<s.length(); i++) {
        	char ch = s.charAt(i);
        	if(ch == ' ') ct = -1;
        	else if(ct%2 == 0) ch = Character.toUpperCase(ch);
        	else ch = Character.toLowerCase(ch);
        	answer += ch;
        	ct++;
        }
        
        return answer;
    }
}