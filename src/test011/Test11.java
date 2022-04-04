package test011;
// 프로그래머스/Level1/2016년
public class Test11 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 5;
		int input2 = 24;
		String output = sol.solution(input1,input2);
		System.out.println(output);

	}

}

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int day = b;
        String[] day_week = {"THU","FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] month_days = {31,29,31,30,31,30,31,31,30,31,30};
        
        for(int i=1; i<a; i++) {
        	day+=month_days[i-1];
        }
        
        answer = day_week[day %= 7];

        return answer;
    }
}