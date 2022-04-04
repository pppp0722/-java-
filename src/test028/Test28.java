package test028;
import java.util.ArrayList;
// 프로그래머스/Level1/자연수 뒤집어 배열로 만들기
public class Test28 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		long input = 12345;
		int[] output = sol.solution(input);
		for(int i : output) System.out.println(i);
	}
}

class Solution {
    public int[] solution(long n) {
        ArrayList<Integer> al = new ArrayList<>();
        
        while(n>0) {
        	al.add((int)(n%10));
        	n /= 10;
        }
        
        int[] answer = new int[al.size()];
        for(int i=0; i<al.size(); i++) answer[i] = al.get(i);
        
        return answer;
    }
}