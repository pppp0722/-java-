package test013;
import java.util.ArrayList;
// 프로그래머스/Level1/[1차] 다트 게임
public class Test13 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String input1 = "1D#2S*3S";
		int output = sol.solution(input1);
		System.out.println(output);
	}
}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> al = new ArrayList<>();
        int ct = 0;
        
        while(ct < dartResult.length()) {
        	char ch = dartResult.charAt(ct++);
        	if(ch == '*') {
        		al.set(al.size()-1,2*al.get(al.size()-1));
        		if(al.size()>1) al.set(al.size()-2,2*al.get(al.size()-2));
        	}
        	else if(ch == '#') al.set(al.size()-1,-1*al.get(al.size()-1));
        	else {
        		char ch2 = dartResult.charAt(ct++);
        		if(ch2 == '0') {
        			char ch3 = dartResult.charAt(ct++);
        			if(ch3 == 'S') al.add(10);
        			else if(ch3 == 'D') al.add((int)Math.pow(10,2));
        			else al.add((int)Math.pow(10, 3));
        		}
        		else {
        			int num = ch - '0';
        			if(ch2 == 'S') al.add(num);
        			else if(ch2 == 'D') al.add((int)Math.pow(num,2));
        			else al.add((int)Math.pow(num, 3));
        		}
        	}
        }
        
        for(int i : al) answer += i;
        
        return answer;
    }
}