package test037;
// 프로그래머스/Level1/핸드폰 번호 가리기
public class Test37 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "01033334444";
		String output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        for(int i=0; i<phone_number.length();i++) {
        	answer += i < phone_number.length()-4? '*' : phone_number.charAt(i);
        }
        
        return answer;
    }
}