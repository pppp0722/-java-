package test051;
// 프로그래머스 Level1 부족한 금액 계산하기
public class Test51 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 3;
		int input2 = 20;
		int input3 = 4;
		long output = sol.solution(input1, input2, input3);
		System.out.println(output);
	}
		

}

class Solution {
    public long solution(int price, int money, int count) {
        return money - price*sequence(count) < 0 ? price*sequence(count) - money : 0;
    }
    
    public long sequence(int n) {
    	if(n == 1) return 1;
    	return n + sequence(n-1);
    }
}