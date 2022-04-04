package test062;
// 프로그래머스 Level2 타겟 넘버
public class Test62 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input1 = {1, 1, 1, 1, 1};
		int input2 = 3;
		int output = sol.solution(input1, input2);
		System.out.println(output);
	}
}

class Solution {
	int ct = 0;
	int[] arr;
	int score;
    public int solution(int[] numbers, int target) {
    	arr = numbers;
    	score = target;
    	
        DFS(0,0);
        
        return ct;
    }
    
    public void DFS(int num, int depth) {
    	if(depth == arr.length) {
    		if(num == score) {
    			ct++;
    		}
    		return;
    	}
    	DFS(num + arr[depth], depth + 1);
    	DFS(num - arr[depth], depth + 1);
    }
}