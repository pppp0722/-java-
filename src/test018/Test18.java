package test018;
import java.util.Arrays;
import java.util.Collections;
// 프로그래머스/Level1/문자열 내림차순으로 배치하기
public class Test18 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "Zbcdefg";
		String output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public String solution(String s) {
        String str[] = s.split("");
        Arrays.sort(str);
        Collections.reverse(Arrays.asList(str));
        
        return String.join("", str);
    }
}