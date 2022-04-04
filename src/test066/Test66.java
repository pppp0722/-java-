package test066;

import java.util.ArrayList;
import java.util.Stack;

// 프로그래머스 데브코스 코딩테스트 2번 문제
public class Test66 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = {"john share", "mary comment", "jay share", "check notification", "check notification", "sally comment", "james share", "check notification", "lee share", "laura share", "will share", "check notification", "alice comment", "check notification"};
		String[] output = sol.solution(input);
		for(String s : output) {
			System.out.println(s);
		}
	}
}

class Solution {
    public String[] solution(String[] records) {
    	Stack<String> notices = new Stack<>();
    	Stack<Integer> counts = new Stack<>();
        ArrayList<String> locker = new ArrayList<>();
        
        for(String s : records) {
        	if(s.equals("check notification")) {
        		locker.add(notices.pop());
        		counts.pop();
        		continue;
        	}
        	String[] splited = s.split(" ");
        	String name = splited[0];
        	String option = splited[1];
        	String lastMessage = notices.size() > 0 ? notices.peek() : "";
        	String message = "";
        	
        	//System.out.println(lastMessage +"!");
        	
        	if(!lastMessage.equals("") && lastMessage.contains(option)) {
        		notices.pop();
        		int ct = counts.pop();
        		if(ct == 1) {
        			message = lastMessage.split(" ")[0] + " and " + name + (option.equals("share") ? " shared" : " commented on") + " your post";
        		} else {
        			message = lastMessage.split(" ")[0] + " and " + ct +" others" + (option.equals("share") ? " shared" : " commented on") + " your post";
        		}
        		counts.push(ct + 1);
        	}else {
        		message = name + (option.equals("share") ? " shared" : " commented on") + " your post";
        		counts.push(1);
        	}
        	
        	notices.push(message);
        }
        
        return locker.toArray(new String[locker.size()]);
    }
}