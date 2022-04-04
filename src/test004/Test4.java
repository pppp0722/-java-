package test004;
// 프로그래머스/Level1/로또의 최고 순위와 최저 순위
public class Test4 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input1 = {1,2,3,4,5,6};
		int[] input2 = {7,8,9,10,11,12};
		int[] output = sol.solution(input1, input2);
		System.out.println(output[0] + " " + output[1]);
	}

}

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correct = 0;
        int zero = 0;
        
        for(int i=0; i<lottos.length; i++) {
        	if(lottos[i] == 0) {
        		zero++;
        		continue;
        	}
        	for(int j=0; j<win_nums.length; j++) {
        		if(lottos[i] == win_nums[j]) correct++;
        	}
        }
        
        answer[0] = 7 - correct - zero;
        if(answer[0] == 7) answer[0] = 6;
        answer[1] = 7 - correct;
        if(answer[1] == 7) answer[1] = 6;
        
        return answer;
    }
}