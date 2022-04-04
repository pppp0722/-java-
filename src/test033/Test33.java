package test033;
// 프로그래머스/Level1/최대공약수와 최소공배수
public class Test33 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 3;
		int input2 = 12;
		int[] output = sol.solution(input1, input2);
		for(int i : output) System.out.println(i);
	}
}

class Solution {
    public int[] solution(int n, int m) {
        int max = 0;

        int a = n>m? n:m;
        int b = n<=m? n:m;
        
        for(int i=1; i<=b; i++) {
        	if(a%i == 0 && b%i == 0) max = i;
        }
        
        return new int[] {max,a*b/max};
    }
}