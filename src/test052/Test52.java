package test052;

import java.util.stream.IntStream;

// 프로그래머스 Level1 없는 숫자 더하기
public class Test52 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] input = {1, 2, 3, 4, 6, 7, 8, 0};
		int output = sol.solution(input);
		System.out.println(output);
	}
		

}

class Solution {
    public int solution(int[] numbers) {
        return 45 - IntStream.of(numbers).sum();
    }
}