package test003;
// 프로그래머스/Level1/내적
public class Test3 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input1 = {1,2,3,4};
		int[] input2 = {-3,-1,0,2};
		int output = sol.solution(input1, input2);
		System.out.println(output);
	}

}

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i=0; i<a.length; i++) {
        	answer += a[i]*b[i];
        }
        
        return answer;
    }
}