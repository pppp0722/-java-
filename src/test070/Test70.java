package test070;
//프로그래머스 Level3 베스트앨범
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class Test70 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input1 = {"classic", "pop", "classic", "classic", "pop"};
		int[] input2 = {500, 600, 150, 800, 2500};
		int[] output = sol.solution(input1, input2);
		for(Integer i : output) {
			System.out.println(i);
		}
	}
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, ArrayList<Integer[]>> genreIndexes = new HashMap<>();
        HashMap<String, Integer> genreSumOfPlays = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
        	ArrayList<Integer[]> list;
        	if(!genreIndexes.containsKey(genres[i])) {
        		list = new ArrayList<Integer[]>();
        		Integer[] iArr = new Integer[2];
        		iArr[0] = i;
        		iArr[1] = plays[i];
        		list.add(iArr);
        		genreIndexes.put(genres[i], list);
        		genreSumOfPlays.put(genres[i], plays[i]);
        	} else {
        		list = genreIndexes.get(genres[i]);
        		Integer[] iArr = new Integer[2];
        		iArr[0] = i;
        		iArr[1] = plays[i];
        		list.add(iArr);
        		genreIndexes.remove(genres[i]);
        		genreIndexes.put(genres[i], list);
        		
        		int sum = genreSumOfPlays.get(genres[i]);
        		sum += plays[i];
        		genreSumOfPlays.remove(genres[i]);
        		genreSumOfPlays.put(genres[i], sum);
        	}
        }
        
        List<String> listKeySet = new ArrayList<>(genreSumOfPlays.keySet());
	    Collections.sort(listKeySet, (k1, k2) -> (genreSumOfPlays.get(k2).compareTo(genreSumOfPlays.get(k1))));
        
        for(String s : listKeySet) {
        	ArrayList<Integer[]> list = genreIndexes.get(s);
        	if(list.size() > 1) {
        		Collections.sort(list, (a1, a2) -> (a2[1].compareTo(a1[1])));
        		answer.add(list.get(0)[0]);
        		answer.add(list.get(1)[0]);
        	} else {
        		answer.add(list.get(0)[0]);
        	}
        }
        
        int[] ret = new int[answer.size()];
        
        for(int i = 0; i < answer.size(); i++) {
        	ret[i] = answer.get(i);
        }
        
        return ret;
    }
}