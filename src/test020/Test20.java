package test020;
// 프로그래머스/Level1/서울에서 김서방 찾기
public class Test20 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = {"Jane","Kim"};
		String output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public String solution(String[] seoul) {
    	String answer = "";
    	
    	for(int i=0; i<seoul.length; i++) {
    		if(seoul[i].equals("Kim")) answer = "김서방은 "+i+"에 있다";
    	}
    	
        return answer;
    }
}