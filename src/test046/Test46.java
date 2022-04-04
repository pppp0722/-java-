package test046;
// ICT 인턴쉽 코딩테스트 5번 문제
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test46 {
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
		String[] binary_tree = new String[1000];
		Arrays.fill(binary_tree, null);
		
		// 디코딩 하기 위하여 주어진 이진 트리 자리에 문자열을 넣는다.
		for(String s : codes) {
			String[] strs = s.split("\\s+");
			
			int index = 1;
			for(int i=0; i<strs[1].length(); i++) {
				char c = strs[1].charAt(i);
				index *= 2;
				if(c == '1') index++;
			}
			binary_tree[index] = strs[0].equals("[newline]") ? "\n" : strs[0];
		}
		
		// 디코딩 과정은 코드를 따라가며 해당 자리에 문자가 존재하면 decoded에 추가해주고 이진 트리 index를 초기화 시켜주는 것을 반복
		String decoded = "";
		int index = 1;
		for(int i=0; i<encoded.length(); i++) {
			char c = encoded.charAt(i);
			index *= 2;
			if(c == '1') index++;
			
			if(binary_tree[index] != null) {
				decoded += binary_tree[index];
				index = 1;
			}
		}
		
		return decoded;
    }
}
