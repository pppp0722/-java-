package test001;
// 프로그래머스/Level1/실패율
public class Test1 {
		public static void main(String[] args) {
			Solution sol = new Solution();
			int[] input = {2, 1, 6, 2, 2, 4, 3, 3};
			int[] output = sol.solution(5, input);
			for(int i : output) System.out.println(i);
		}

	}

	class Solution {
	    public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        int[] clear = new int[N];
	        int[] fail = new int[N];
	        float[] per_fail = new float[N];
	        int i,j;
	        
	        for(i=0; i<N; i++) answer[i] = i+1;
	        
	        for(i=0; i<stages.length; i++){
	            for(j=0; j<stages[i]-1; j++){
	                clear[j]++;
	            }
	            if(stages[i] != N+1) fail[stages[i]-1]++;
	        }
	        
	        for(i=0; i<N; i++) {
	        	if(fail[i] == 0) {
	        		per_fail[i] = 0;
	        		continue;
	        	}
	        	per_fail[i] = (float)fail[i]/(fail[i]+clear[i]);
	        }
	        
	        for(i=1; i<N; i++){
	        	float tmp_per_fail = per_fail[i];
	            int tmp_answer = answer[i];
	            for(j=i-1; j>=0; j--){
	                if(tmp_per_fail <= per_fail[j]) break;
	                per_fail[j+1] = per_fail[j];
	                answer[j+1] = answer[j];
	            }
	            per_fail[j+1] = tmp_per_fail;
	            answer[j+1] = tmp_answer;
	        }
	        
	        return answer;
	    }
	}