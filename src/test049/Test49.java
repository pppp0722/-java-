package test049;
// 프로그래머스 Level1 숫자 문자열과 영단어
public class Test49 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "one4seveneight";
		int output = sol.solution(input);
		System.out.println(output);
	}

}

class Solution {
    public int solution(String s) {
    	String[] alphabets = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    	for(int i = 0; i < 10; i++) {
    		s = s.replaceAll(alphabets[i], Integer.toString(i));
    	}
        return Integer.parseInt(s);
    }
}