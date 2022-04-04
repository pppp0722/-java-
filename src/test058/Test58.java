package test058;
// 프로그래머스 Level2 멀쩡한 사각형
public class Test58 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 8;
		int input2 = 12;
		long output = sol.solution(input1, input2);
		System.out.println(output);
	}
}

class Solution {
    public long solution(int w,int h) {
        long cnt = 0;
        for(int i = 0; i < w; i++) {
        	cnt += Math.ceil((double)h * (i+1) / w) - Math.floor((double)h * i / w);
        }
        return (long)w * h - cnt;
    }
}