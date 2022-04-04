package test040;
import java.util.Scanner;
// 프로그래머스/Level1/직사각형 별찍기
public class Test40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) System.out.print('*');
        	System.out.println();
        }
    }
}