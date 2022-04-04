package test029;
import java.util.ArrayList;
import java.util.Collections;
// 프로그래머스/Level1/정수 내림차순으로 배치하기
public class Test29 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		long input = 118372;
		long output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public long solution(long n) {
        long answer = 0;
        ArrayList<Integer> al = new ArrayList<>();
        
        while(n>0) {
        	al.add((int)(n%10));
        	n /= 10;
        }
        
        Collections.sort(al);
        
        long ct = 1;
        for(int i : al) {
        	answer += ct * i;
        	ct *= 10;
        }
        
        return answer;
    }
}