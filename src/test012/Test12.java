package test012;
import java.util.Arrays;
// 프로그래머스/Level1/[1차] 비밀지도
public class Test12 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 5;
		int[] input2 = {9,20,28,18,11};
		int[] input3 = {30,1,21,17,28};
		String[] output = sol.solution(input1,input2,input3);
		for(String s : output) System.out.println(s);
	}
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Arrays.fill(answer, "");
        
        for(int i=0; i<n; i++) {
        	int[] first = new int[n];
        	int[] second = new int[n];
        	
        	int arr1_num = arr1[i];
        	int arr2_num = arr2[i];
        	
        	int ct = 0;
        	while(arr1_num > 0) {
        		first[ct++] = arr1_num % 2;
        		arr1_num /= 2;
        	}
        	
        	ct = 0;
        	while(arr2_num > 0) {
        		second[ct++] = arr2_num % 2;
        		arr2_num /= 2;
        	}
        	
        	for(int j=n-1; j>=0; j--) {
        		if(first[j] == 1 || second[j] == 1) answer[i] += "#";
        		else answer[i] += " ";
        	}
        }
        return answer;
    }
}