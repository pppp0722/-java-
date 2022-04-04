package test038;
// 프로그래머스/Level1/행렬의 덧셈
public class Test38 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] input1 = {{1,2},{2,3}};
		int[][] input2 = {{3,4},{5,6}};
		int[][] output = sol.solution(input1, input2);
		for(int[] i1 : output) {
			for(int i2 : i1) System.out.println(i2);
		}
	}
}

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        for(int i=0; i<arr1.length; i++) {
        	for(int j=0; j<arr1[0].length; j++) {
        		answer[i][j] = arr1[i][j] + arr2[i][j];
        	}
        }
        
        return answer;
    }
}