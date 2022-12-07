package test223;
// PQ/백준/골드4/13975 파일 합치기 3

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            long result = 0;
            while (pq.size() > 1) {
                long size1 = pq.poll();
                long size2 = pq.poll();
                long sum = size1 + size2;
                result += sum;
                pq.offer(sum);
            }
            sb.append(result).append(lineSeparator());
        }
        System.out.println(sb);
    }
}
