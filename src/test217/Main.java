package test217;
// 그리디/백준/골드2/8980 택배

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        Packet[] packets = new Packet[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int boxNum = Integer.parseInt(st.nextToken());
            packets[i] = new Packet(start, end, boxNum);
        }

        // 그리디 위한 정렬
        Arrays.sort(packets);

        // 각 마을당 보낼 수 있는 최대 수 초기화 (마지막 마을은 못보냄)
        int[] maxNumPerTown = new int[n + 1];
        for (int i = 1; i < n; i++) {
            maxNumPerTown[i] = c;
        }

        // 그리디
        int answer = 0;
        for (int i = 0; i < m; i++) {
            Packet packet = packets[i];

            // 보낼 수 있는 최대 수 설정
            int maxNum = maxNumPerTown[packet.from];
            for (int j = packet.from + 1; j < packet.to; j++) {
                maxNum = Math.min(maxNumPerTown[j], maxNum);
            }

            // 택배 수와 최대 수 중 더 작은 값
            int num = Math.min(packet.num, maxNum);

            // 각 마을당 보낼 수 있는 최대 수 감소
            for (int j = packet.from; j < packet.to; j++) {
                maxNumPerTown[j] -= num;
            }

            answer += num;
        }

        System.out.println(answer);

        br.close();
    }
}

class Packet implements Comparable<Packet> {

    public int from;
    public int to;
    public int num;

    public Packet(int from, int to, int num) {
        this.from = from;
        this.to = to;
        this.num = num;
    }

    @Override
    public int compareTo(Packet o) {
        if (to == o.to) {
            return from - o.from;
        }
        return to - o.to;
    }
}