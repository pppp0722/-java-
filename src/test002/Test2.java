package test002;
// 프로그래머스/Level1/소수 만들기
public class Test2 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input = {1,2,7,6,4};
		int output = sol.solution(input);
		System.out.println(output);
	}

}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i=0; i<nums.length-2; i++) {
        	for(int j=i+1; j<nums.length-1; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			int num = nums[i]+nums[j]+nums[k];
        			int ct = 0;
        			for(int l=2; l<num; l++) {
        				if(num%l == 0) ct++;
        			}
        			if(ct == 0) answer++;
        		}
        	}
        }
        
        return answer;
    }
}