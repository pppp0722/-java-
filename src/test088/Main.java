package test088;
// 백준/실버1/1931번 회의실 배정
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] usages = new int[num][2];
        for (int i = 0; i < num; i++) {
            int[] time = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            usages[i] = time;
        }

        Arrays.sort(usages, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int answer = 0;
        int endTime = 0;
        for (int i = 0; i < usages.length; i++) {
            if (usages[i][0] >= endTime) {
                answer++;
                endTime = usages[i][1];
            }
        }

        System.out.println(answer);
    }
}