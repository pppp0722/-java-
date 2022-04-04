package test015;
import java.util.ArrayList;
import java.util.Collections;
// 프로그래머스/Level1/나누어 떨어지는 숫자 배열
public class Test15 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input1 = {5,9,7,10};
		int input2 = 5;
		int[] output = sol.solution(input1,input2);
		for(int i : output) System.out.println(i);
	}
}

class Solution {
    public int[] solution(int[] arr, int divisor) {
    	int[] answer = {-1};
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i : arr) {
        	if(i % divisor == 0) al.add(i);
        }
        
        if(al.size() > 0) {
        	Collections.sort(al);
        	answer = new int[al.size()];
        
        	for(int i=0; i<al.size(); i++) answer[i] = al.get(i);
        }
        
        return answer;
    }
}