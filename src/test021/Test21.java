package test021;
// 프로그래머스/Level1/소수 찾기
public class Test21 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input = 10;
		int output = sol.solution(input);
		System.out.println(output);
	}
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] arr = new boolean[n+1];
        arr[0] = arr[1] = false;
        for(int i=2; i<=n; i++) arr[i] = true;
        
        for(int i=2; i*i<=n; i++) {
        	if(arr[i] == true) {
        		for(int j=i*i; j<=n; j+=i) arr[j] = false;
        	}
        }
        
        for(boolean b : arr) {
        	if(b) answer++;
        }
        
        return answer;
    }
}