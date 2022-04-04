package test009;
import java.util.Arrays;
// 프로그래머스/Level1/예산
public class Test9 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input1 = {1,3,2,5,4};
		int input2 = 9;
		int output = sol.solution(input1, input2);
		System.out.println(output);
	}

}

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int spend = 0;
        Arrays.sort(d);
        
        for(int i : d) {
        	if(spend + i > budget) break;
        	spend += i;
        	answer++;
        }
        
        return answer;
    }
}