package test076;

// 백준/골드5/1759번 암호 만들기
// Backtracking

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int length;
    static char[] password;
    static int numOfAlphabets;
    static char[] alphabets;
    static boolean[] visited;
    static Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");
        Arrays.sort(input2);

        length = Integer.parseInt(input1[0]);
        password = new char[length];
        numOfAlphabets = Integer.parseInt(input1[1]);
        alphabets = new char[numOfAlphabets];
        visited = new boolean[numOfAlphabets];
        for(int i = 0; i < numOfAlphabets; i++) {
            alphabets[i] = input2[i].charAt(0);
        }

        backtracking(0);
        System.out.print(stringBuilder.toString());

        scanner.close();
    }

    public static void backtracking(int depth) {
        if(depth == length) {
            int numOfVowels = 0;
            String newPassword = "";
            for (char alphabet : password) {
                if(Arrays.stream(vowels).anyMatch(c -> c == alphabet)) {
                    numOfVowels++;
                }

                newPassword += alphabet;
            }

            if(numOfVowels > 0 && length - numOfVowels > 1) {
                stringBuilder.append(newPassword).append("\n");
            }

            return;
        }

        for(int i = 0; i < numOfAlphabets; i++) {
            if(visited[i]) continue;

            if(depth > 0 && alphabets[i] <= password[depth - 1]) {
                continue;
            }

            visited[i] = true;
            password[depth] = alphabets[i];
            backtracking(depth + 1);
            visited[i] = false;
        }
    }
}