package test064;
import java.util.Arrays;
import java.util.Comparator;
// 프로그래머스 Level2 가장 큰 수

public class Test64 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input = {0, 0, 0};
		String output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public String solution(int[] numbers) {
        Integer[] nums = new Integer[numbers.length];
        for (int i=0; i<numbers.length; i++) 
            nums[i] = numbers[i];

        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                String s1 = i1.toString();
                String s2 = i2.toString();
                return ((s2+s1)).compareTo(s1+s2);
            }
        });

        String answer = "";
        for(Integer i : nums) {
        	answer += i.toString();
        }

        if(answer.substring(0, 1).equals("0"))
            answer = "0";

        return answer;
    }
}