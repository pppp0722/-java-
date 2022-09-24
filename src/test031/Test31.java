package test031;
// 프로그래머스/Level1/제일 작은 수 제거하기

import java.util.ArrayList;

public class Test31 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = {1, 2, 3, 4, 5};
        int[] output = sol.solution(input);
		for (int i : output) {
			System.out.println(i);
		}
    }
}

class Solution {

    public int[] solution(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();

        int min_num = arr[0];
        for (int i = 1; i < arr.length; i++) {
			if (min_num > arr[i]) {
				min_num = arr[i];
			}
        }

        for (int i = 0; i < arr.length; i++) {
			if (arr[i] > min_num) {
				al.add(arr[i]);
			}
        }

        int[] answer = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			answer[i] = al.get(i);
		}

        return answer.length == 0 ? new int[]{-1} : answer;
    }
}