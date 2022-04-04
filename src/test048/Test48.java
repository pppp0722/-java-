package test048;
import java.util.Arrays;
import java.util.Stack;
// 프로그래머스/Level3/표 편집

public class Test48 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int input1 = 8;
		int input2 = 2;
		String[] input3 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		String output = sol.solution(input1, input2, input3);
		System.out.println(output);

	}

}

class Solution {
    public String solution(int n, int k, String[] cmd) {
    	char[] strs = new char[n];
    	Arrays.fill(strs, 'O');
    	
    	int current_index = k;
    	int last_index = n-1;
    	Stack<Integer> delete_stack = new Stack<>();
    	for(String s : cmd) {
    		if(s.equals("C")) { // 삭제
    			delete_stack.push(current_index);
    			strs[current_index] = 'X';
    			if(current_index == last_index) {
    				for(int i=current_index-1; i>=0; i--) {
    					if(strs[i] == 'O') {
    						current_index = i;
    						last_index = i;
    						break;
    					}
    				}
    			} else {
    				for(int i=current_index+1; i<=last_index; i++) {
    					if(strs[i] == 'O') {
    						current_index = i;
    						break;
    					}
    				}
    			}
    			continue;
    		}
    		else if(s.equals("Z")) { // 복구
    			int last_delete = delete_stack.pop();
    			strs[last_delete] = 'O';
    			if(last_delete > last_index) last_index = last_delete;
    			continue;
    		}
    		 
    		String[] splited = s.split(" ");
    		int ct = 0;
    		int times = Integer.parseInt(splited[1]);
    		if(splited[0].equals("U")) { // 위로
    			while(ct < times){
    				current_index--;
    				if(strs[current_index] == 'O') ct++;
    			}
    		}
    		else if(splited[0].equals("D")) { // 아래로
    			while(ct < times){
    				current_index++;
    				if(strs[current_index] == 'O') ct++;
    			}
    		}
    		
    		continue;
    	}
    	
        return new String(strs);
    }
}