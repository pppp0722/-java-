package test006;
// 프로그래머스/Level1/키패드 누르기
public class Test6 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input1 = {1,3,4,5,8,2,1,4,5,9,5};
		String input2 = "right";
		String output = sol.solution(input1, input2);
		System.out.println(output);
	}

}

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] priority = {{3,1,0,1,2,1,2,3,2,3,4,4},{2,2,1,2,1,0,1,2,1,2,3,3},{1,3,2,3,2,1,2,1,0,1,2,2},{0,4,3,4,3,2,3,2,1,2,1,1}};
        int left = 10;
        int right = 11;
 
        
        for(int i=0; i<numbers.length; i++) {
        	if(numbers[i]%3 == 1) {
        		answer += "L";
        		left = numbers[i];
        	}
        	else if(numbers[i]%3 == 0 && numbers[i] != 0) {
        		answer += "R";
        		right = numbers[i];
        	}
        	else {
        		int n;
        		if(numbers[i] == 2) n=0;
        		else if(numbers[i] == 5) n=1;
        		else if(numbers[i] == 8) n=2;
        		else n=3;
        		
        		if(priority[n][left] < priority[n][right]) {
        			answer += "L";
        			left = numbers[i];
        		}else if(priority[n][left] > priority[n][right]) {
        			answer += "R";
        			right = numbers[i];
        		}else {
        			if(hand.equals("left")) {
        				answer += "L";
            			left = numbers[i];
        			}else {
        				answer += "R";
            			right = numbers[i];
        			}
        		}
        	}
        }
        return answer;
    }
}