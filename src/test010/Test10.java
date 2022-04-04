package test010;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
// 프로그래머스/Level1/3진법 뒤집기
public class Test10 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int input1 = 125;
		int output = sol.solution(input1);
		System.out.println(output);

	}

}

class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = n;
        ArrayList<Integer> al = new ArrayList<>();
        while(num > 0) {
        	al.add(num%3);
        	num /= 3;
        }
        
        Collections.reverse(al);
        
        Iterator<Integer> itr = al.iterator();
        int i=0;
        while(itr.hasNext()) {
        	answer += itr.next()*Math.pow(3, i++);
        }
        
        
        return answer;
    }
}