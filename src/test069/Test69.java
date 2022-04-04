package test069;
// 프로그래머스 Level2 위장

import java.util.HashMap;

public class Test69 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[][] input = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		int output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public int solution(String[][] clothes) {
    	int answer = clothes.length;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String[] sArr : clothes) {
        	if(!hm.containsKey(sArr[1])) {
        		hm.put(sArr[1], 1);
        	} else {
        		hm.put(sArr[1], hm.get(sArr[1]) + 1);
        	}
        }
        
        if(hm.size() > 1) {
        	int ct = 1;
        	for(String key : hm.keySet()) {
        		ct *= hm.get(key) + 1;
        	}
        	
        	answer = ct - 1;
        }
        
        return answer;
    }
}