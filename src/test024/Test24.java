package test024;
// 프로그래머스/Level1/시저 암호
public class Test24 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input1 = "AB";
		int input2 = 1;
		String output = sol.solution(input1, input2);
		System.out.println(output);
	}
}

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = new char[s.length()];
        
        for(int i=0; i<s.length(); i++) {
        	arr[i] = s.charAt(i);
        }
        
        for(int i=0; i<arr.length; i++) {
        	if(Character.isAlphabetic(arr[i])) {
        		if(Character.isUpperCase(arr[i])) answer += (char)('A'+(arr[i]+n-'A')%('Z'-'A'+1));
        		else answer += (char)('a'+(arr[i]+n-'a')%('z'-'a'+1));
        	} else answer += arr[i];
        }
        
        return answer;
    }
}