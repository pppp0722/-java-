package test238;
// 트리셋/백준/골드4/21939 문제 추천 시스템 Version 1

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeSet<Problem> treeSet = new TreeSet<>((o1, o2) -> {
            if (o1.l == o2.l) {
                return o2.p - o1.p;
            }
            return o2.l - o1.l;
        });
        Map<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int p;
        int l;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            treeSet.add(new Problem(p, l));
            map.put(p, l);
        }
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        String command;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if ("recommend".equals(command)) {
                command = st.nextToken();
                if ("1".equals(command)) {
                    sb.append(treeSet.first().p).append(lineSeparator());
                } else {
                    sb.append(treeSet.last().p).append(lineSeparator());
                }
            } else if ("add".equals(command)) {
                p = Integer.parseInt(st.nextToken());
                l = Integer.parseInt(st.nextToken());
                treeSet.add(new Problem(p, l));
                map.put(p, l);
            } else {
                p = Integer.parseInt(st.nextToken());
                treeSet.remove(new Problem(p, map.get(p)));
                map.remove(p);
            }
        }
        System.out.println(sb);
    }
}

class Problem {

    public int p;
    public int l;

    public Problem(int p, int l) {
        this.p = p;
        this.l = l;
    }
}