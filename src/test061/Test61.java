package test061;

import java.util.PriorityQueue;

// 프로그래머스 Level2 더맵게
public class Test61 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input1 = {1, 2, 3, 9, 10, 12};
		int input2 = 7;
		int output = sol.solution(input1, input2);
		System.out.println(output);
	}
}

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer i : scoville) {
        	pq.add(i);
        }
        
        int ct = 0;
        while(pq.peek() < K) {
        	if(pq.size() == 1) return -1;
        	Integer first = pq.remove();
        	Integer second = pq.remove();
        	pq.add(first + second * 2);
        	ct++;
        }
        
        return ct;
    }
}