package test056;

import java.util.ArrayList;
import java.util.HashMap;
// 프로그래머스 Level2 오픈채팅방

public class Test56 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] output = sol.solution(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
}

class Solution {
    public String[] solution(String[] record) {
    	HashMap<String,String> uidName = new HashMap<>();
    	ArrayList<String[]> command = new ArrayList<>();
    	
    	for(String r : record) {
    		String[] splited = r.split(" ");
    		
    		switch(splited[0]) {
	    	case "Enter":
	    		command.add(new String[]{splited[0], splited[1]});
	    		uidName.put(splited[1], splited[2]);
	    		break;
	    	case "Leave":
	    		command.add(new String[]{splited[0], splited[1]});
	    		break;
	    	case "Change":
	    		uidName.put(splited[1], splited[2]);
    		}
    	}
    	
    	String[] answer = new String[command.size()];
    	
    	for(int i = 0; i < command.size(); i++) {
    		answer[i] = uidName.get(command.get(i)[1]) + (command.get(i)[0].equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.");
    	}
	    	
    	return answer;
    }
}