package test041;
// 프로그래머스/Level1/신규 아이디 추천
public class Test41 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "...!@BaT#*..y.abcdefghijklm";
		String output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id.toLowerCase()); // 1단계
        
        int idx = 0; // 2단계
        while(idx < sb.length()) {
        	char c = sb.charAt(idx);
        	if(!Character.isAlphabetic(c) &&
        			!Character.isDigit(c) &&
        			c != '_' && c != '-' && c != '.') sb.deleteCharAt(idx);
        	else idx++;
        }
        
        idx = 1; // 3단계
        while(idx < sb.length()) {
        	char c_pre = sb.charAt(idx-1);
        	char c = sb.charAt(idx);
        	if(c_pre == '.' && c == '.') sb.deleteCharAt(idx);
        	else idx++;
        }
        
        if(sb.length() != 0 && sb.charAt(0) == '.') sb.deleteCharAt(0); // 4단계
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        
        if(sb.length() == 0) sb.append('a'); // 5단계
        
        if(sb.length() > 15) { // 6단계
        	sb = new StringBuilder(sb.substring(0, 15));
        	if(sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        }
        
        for(int i = sb.length(); i<3; i++) sb.append(sb.charAt(i-1)); // 7단계
        
        return sb.toString();
    }
}