package test055;
// 프로그래머스 Level2 문자열 압축

public class Test55 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String input = "aabbaccc";
		int output = sol.solution(input);
		System.out.println(output);
	}
		

}

class Solution {
    public int solution(String s) {
        int minLength = s.length();
        for(int i = 1; i <= s.length() / 2; i++) {
        	int length = s.length();
        	int continuous = 1;
        	for(int j = i; j + i - 1 < s.length(); j += i) {
        		String pre = s.substring(j - i, j);
        		String next = s.substring(j, j + i);
        		if(pre.equals(next)) {
        			continuous++;
        			length -= i;
        		}else {
        			if(continuous > 1) {
        				length += String.valueOf(continuous).length();
        			}
        			continuous = 1;
        		}
        	}
        	if(continuous > 1) {
				length += String.valueOf(continuous).length();
			}
        	if(length < minLength) {
        		minLength = length;
        	}
        }
        return minLength;
    }
}