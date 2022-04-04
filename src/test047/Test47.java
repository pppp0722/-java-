package test047;
// ICT 인턴쉽 코딩테스트 6번 문제
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test47 {

	public static void main(String[] args) {
		List<String> al = new ArrayList<>();
		al.add("a 	100100");
		al.add("b	100101");
		al.add("c	110001");
		al.add("d	100000");
		al.add("[newline]	111111");
		al.add("p	111110");
		al.add("q	000001");
		
		String encoded = "111110000001100100111111100101110001111110";
		
		System.out.println(decode(al,encoded));
	}
	
	public static String decode(List<String> codes, String encoded) {
		Map<String,String> hm = new HashMap<>();
		
		// map 생성 key -> code, value -> char
		for(int i=0; i<codes.size(); i++) {
			String[] strs = codes.get(i).split("\t");
			hm.put(strs[1], strs[0]);
		}
		
		// 디코딩 하기
		String decoded = "";
		String str = "";
		for(int i=0; i<encoded.length(); i++) {
			str += encoded.charAt(i);
			if(hm.containsKey(str)) {
				decoded += hm.get(str).equals("[newline]") ? "\n" : hm.get(str);
				str = "";
			}
		}
		
		return decoded;
    }
}