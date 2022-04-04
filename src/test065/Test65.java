package test065;
// 프로그래머스 데브코스 코딩테스트 1번 문제
public class Test65 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input = {1, 52, 125, 10, 25, 201, 244, 192, 128, 23, 203, 98, 154, 255};
		int output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public int solution(int[] arr) {
    	int minDiff;
    	int minThres = 0;
    	
    	int initialLeft = 0;
		int initialRight = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < 0) {
				initialLeft++;
			}else {
				initialRight++;
			}
		}
		
		minDiff = Math.abs(initialLeft - initialRight);
    	
    	for(int i = 0; i < arr.length - 1; i++) {
    		int left = 0;
    		int right = 0;
    		for(int j = 0; j < arr.length; j++) {
    			if(arr[j] < arr[i] + 1) {
    				left++;
    			}else {
    				right++;
    			}
    		}
    		
    		int thres = Math.abs(left - right);
    		if(thres == minDiff) {
    			if(arr[i] + 1 < minThres) {
    				minThres = arr[i] + 1;
    			}
    		}else if(thres < minDiff) {
    			minDiff = thres;
    			minThres = arr[i] + 1;
    		}
    	}
        
        return minThres;
    }
}