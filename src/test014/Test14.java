package test014;
import java.util.ArrayList;
// 프로그래머스/Level1/같은 숫자는 싫어
public class Test14 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input1 = {1,1,3,3,0,1,1};
		int[] output = sol.solution(input1);
		for(int i : output) System.out.println(i);
	}

}

class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i : arr) {
        	if(al.size() == 0) al.add(i);
        	else if(i != al.get(al.size()-1)) al.add(i);
        }
        
        int[] answer = new int[al.size()];
        for(int i=0; i<al.size();i++) answer[i] = al.get(i);
        		
        return answer;
    }
}