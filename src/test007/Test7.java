package test007;
import java.util.ArrayList;
// 프로그래머스/Level1/폰켓몬
public class Test7 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input = {3,3,3,2,2,4};
		int output = sol.solution(input);
		System.out.println(output);

	}
}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
        	if(answer == nums.length/2) break;
        	if(al.contains(nums[i])) continue;
        	al.add(nums[i]);
        	answer++;
        }
        return answer;
    }
}