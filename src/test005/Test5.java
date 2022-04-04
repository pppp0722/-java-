package test005;
// 프로그래머스/Level1/음양 더하기
public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++) {
        	if(signs[i]) answer += absolutes[i];
        	else answer -= absolutes[i];
        }
        
        return answer;
    }
}