package test050;

// 프로그래머스 Level1 신고 결과 받기
public class Test50 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input1 = {"muzi", "frodo", "apeach", "neo"};
		String[] input2 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int input3 = 2;
		int[] output = sol.solution(input1, input2, input3);
		for(int i=0; i<output.length; i++) {
			System.out.println(output[i]);
		}
	}
		

}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[][] dArr = new int[id_list.length][id_list.length];
        
        for(int i=0; i<report.length; i++) {
        	String[] splited = report[i].split(" ");
        	
        	for(int j=0; j<id_list.length; j++) {
        		if(id_list[j].equals(splited[0])) {
        			for(int l=0; l<id_list.length; l++) {
        				if(id_list[l].equals(splited[1])) {
        					dArr[j][l] = 1;
        				}
        			}
        		}
        	}
        }
        
        for(int i=0; i<dArr.length; i++) {
        	int sum = 0;
        	for(int j=0; j<dArr.length; j++) {
        		sum += dArr[j][i];
        	}
        	
        	if(sum >= k) {
        		for(int l=0; l<dArr.length; l++) {
        			if(dArr[l][i]>0) {
        				answer[l]++;
        			}
        		}
        	}
        }
        
        return answer;
    }
}