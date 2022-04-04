package test043;
// ICT 인턴쉽 코딩테스트 2번 문제
import java.util.stream.IntStream;

public class Test43 {

	public static void main(String[] args) {
		String str = "abab";
		System.out.println(getMinDeletions(str));
	}

	public static int getMinDeletions(String s) {
	        IntStream Stream_str = s.chars();
	        return (int)(s.length() - Stream_str.distinct().count());
	    }
}
