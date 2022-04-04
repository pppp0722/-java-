package test045;
//ICT 인턴쉽 코딩테스트 4번 문제

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test45 {

	public static void main(String[] args) {
		List<Integer> arrival = Arrays.asList(1,1,1,1,4);
		List<Integer> duration = Arrays.asList(10,3,6,4,2);

		System.out.println(maxEvents(arrival,duration));
	}

	public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
		Map<Integer,Integer> hm = new HashMap<>();
        
        // map에 key -> 끝나는 시간, value -> 시작하는 시간 으로 넣어주기
        Iterator<Integer> itr_arrival = arrival.iterator();
        Iterator<Integer> itr_duration = duration.iterator();
        while(itr_arrival.hasNext()) {
        	int arrival_time = itr_arrival.next();
        	int end_time = arrival_time + itr_duration.next();
        	hm.put(end_time, arrival_time);
        }
        
        List<Integer> keys = new ArrayList<>(hm.keySet());
        Collections.sort(keys);
        
        // 탐욕법 -> 먼저 끝나는 순서대로 넣어주기
        int pre_end = 0;
        int ct = 0;
        for(Integer key : keys) {
            if(hm.get(key) >= pre_end) {
                pre_end = key;
                ct++;
            }
        }
        
        return ct;
    }
}