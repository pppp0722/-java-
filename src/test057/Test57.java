package test057;
// 프로그래머스 Level2 카카오프렌즈 컬러링북

public class Test57 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 6;
		int input2 = 4;
		int[][] input3 = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] output = sol.solution(input1, input2, input3);
		for(int i : output) {
			System.out.println(i);
		}
	}
}

class Solution{
	int[][] color2DArray;
	boolean[][] visited;
	
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        color2DArray = picture;
        visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(color2DArray[i][j] != 0 && !visited[i][j]) {
        			numberOfArea++;
        			int totalVisitedNum = dfs(i, j);
        			if(totalVisitedNum > maxSizeOfOneArea) {
        				maxSizeOfOneArea = totalVisitedNum;
        			}
        		}
        	}
        }
        return new int[] {numberOfArea, maxSizeOfOneArea};
    }
    
    public int dfs(int i, int j) {
    	visited[i][j] = true;
    	int visitedNum = 1;
    	if(i > 0 && !visited[i-1][j] && color2DArray[i-1][j] == color2DArray[i][j]) {
    		visitedNum += dfs(i-1, j);
    	}
    	if(i < color2DArray.length - 1 && !visited[i+1][j] && color2DArray[i+1][j] == color2DArray[i][j]) {
    		visitedNum += dfs(i+1, j);
    	}
    	if(j > 0 && !visited[i][j-1] && color2DArray[i][j-1] == color2DArray[i][j]) {
    		visitedNum += dfs(i, j-1);
    	}
    	if(j < color2DArray[0].length - 1 && !visited[i][j+1] && color2DArray[i][j+1] == color2DArray[i][j]) {
    		visitedNum += dfs(i, j+1);
    	}
    	return visitedNum;
    }
}