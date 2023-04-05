package test288;
// 정렬/백준/골드4/2179 비슷한 단어

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        Word[] words = new Word[n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            arr[i] = line;
            words[i] = new Word(i, line);
        }

        // 정렬
        Arrays.sort(words, (w1, w2) -> {
            if (w1.v.equals(w2.v)) {
                return Integer.compare(w1.i, w2.i);
            }
            return w1.v.compareTo(w2.v);
        });

        int[] lengthArr = new int[n];
        int maxLength = 0;

        for (int i = 0; i < n - 1; i++) {
            if (words[i].v.equals(words[i + 1].v)) {
                continue;
            }
            int length = findNumOfSameChars(words[i].v, words[i + 1].v);
            maxLength = Math.max(length, maxLength);
            lengthArr[words[i].i] = Math.max(length, lengthArr[words[i].i]);
            lengthArr[words[i + 1].i] = Math.max(length, lengthArr[words[i + 1].i]);
        }

        // 출력
        for (int i = 0; i < n - 1; i++) {
            if (lengthArr[i] == maxLength) {
                System.out.println(arr[i]);
                for (int j = i + 1; j < n; j++) {
                    if (arr[j].length() >= maxLength && arr[i].substring(0, maxLength)
                        .equals(arr[j].substring(0, maxLength))) {
                        System.out.println(arr[j]);
                        break;
                    }
                }
                break;
            }
        }
    }

    private static int findNumOfSameChars(String word1, String word2) {
        int numOfSameChars = 0;
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                break;
            }
            numOfSameChars++;
        }
        return numOfSameChars;
    }
}

class Word {

    public int i;
    public String v;

    public Word(int i, String v) {
        this.i = i;
        this.v = v;
    }
}