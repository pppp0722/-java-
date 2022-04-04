package test053;

// 프로그래머스 Level1 최소 직사각형
public class Test53 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] input = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		int output = sol.solution(input);
		System.out.println(output);
	}
		

}

class Solution {
    public int solution(int[][] sizes) {
    	int walletW = 0;
    	int walletH = 0;
    	
    	for(int i = 0; i < sizes.length; i++) {
    		int cardW = sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1];
    		int cardH = sizes[i][0] > sizes[i][1] ? sizes[i][1] : sizes[i][0];
    		
    		if(cardW > walletW) walletW = cardW;
    		if(cardH > walletH) walletH = cardH;
    	}
    	
        return walletW * walletH;
    }
}