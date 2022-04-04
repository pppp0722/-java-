package test042;
// ICT 인턴쉽 코딩테스트 1번 문제

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test42 {
	public static void main(String[] args) {
		List<Integer> al = new ArrayList<>();
		al.add(5);
		al.add(10);
		al.add(12);
		al.add(1);
		al.add(10);
		al.add(4);
		
		System.out.println(maxTickets(al));
	}
	
	static int maxTickets(List<Integer> tickets) {
		List<Integer> list_size = new ArrayList<>();
        
        Collections.sort(tickets);
        
        Iterator<Integer> itr = tickets.iterator();
        
        int pre_num = itr.next();
        int ct = 1;
        while(itr.hasNext()){
            int current_num = itr.next();
            if(pre_num + 1 == current_num || pre_num == current_num){
                ct++;
            }
            else{
                list_size.add(ct);
                ct = 1;
            }
            
            pre_num = current_num;
        }
        
        return Collections.max(list_size);
    }
}
