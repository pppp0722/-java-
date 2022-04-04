package test060;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 Level2 기능개발
public class Test60 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input1 = {93, 30, 55};
		int[] input2 = {1, 30, 5};
		int[] output = sol.solution(input1, input2);
		for(Integer i : output) {
			System.out.println(i);
		}
	}
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> al = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
        	q.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        int min = q.remove();
        al.add(1);
        while(!q.isEmpty()) {
        	int num = q.remove();
        	if(num <= min) {
        		al.add(al.remove(al.size()-1) + 1);
        	} else {
        		min = num;
        		al.add(1);
        	}
        }
        
        int[] ret = new int[al.size()];
        for(int i = 0; i < ret.length; i++) {
        	ret[i] = al.get(i).intValue();
        }
        
        return ret;
    }
}