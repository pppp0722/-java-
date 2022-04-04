package test067;
// 프로그래머스 데브코스 코딩테스트 3번 문제

public class Test67 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 6;
		int[] input2 = {1, 1, 2, 3, 4};
		int[][] input3 = {{1, 2}, {1, 3}, {1, 4}, {1, 5}};
		int[] output = sol.solution(input1, input2, input3);
		for(Integer s : output) {
			System.out.println(s);
		}
	}
}

class Solution {
	int num;
	int[] pas;
	int[][] tra;
	int max = 0;
	int maxIndex = 0;
    public int[] solution(int n, int[] passenger, int[][] train) {
    	num = n;
    	pas = passenger;
    	tra = train;
    	
    	for(int i = 0; i < num; i++) {
    		boolean[] visited = new boolean[num];
    		DFS(i, visited, 0);
    	}
    	
        int[] answer = new int[2];
        answer[0] = maxIndex;
        answer[1] = max;
        
        return answer;
    }
    
    public void DFS(int index, boolean[] visited, int sum) {
    	if(visited[index]) return;
    	visited[index] = true;
    	
    	boolean allVisited = true;
    	for(int i = 0; i < tra.length; i++) {
    		if(tra[i][0] - 1 == index) {
    			if(!visited[tra[i][1] - 1]) {
    				allVisited = false;
    			}
    		}
    		if(tra[i][1] - 1 == index) {
    			if(!visited[tra[i][0] - 1]) {
    				allVisited = false;
    			}
    		}
    	}
    	
    	if(allVisited) {
    		if(sum > max) {
    			max = sum;
    			maxIndex = index + 1;
    		}else if(sum == max) {
    			if(index + 1 > maxIndex) {
    				maxIndex = index + 1;
    			}
    		}
    	} else {
	    	for(int i = 0; i < tra.length; i++) {
	    		if(tra[i][0] == index + 1) {
	    			DFS(tra[i][1] - 1, visited, sum + pas[index]);
	    		}
	    		if(tra[i][1] == index + 1) {
	    			DFS(tra[i][0] - 1, visited, sum + pas[index]);
	    		}
	    	}
    	}
    }
}