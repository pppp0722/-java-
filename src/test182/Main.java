package test182;
// 백준/골드5/5430 AC

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            line = line.substring(1, line.length() - 1);
            StringTokenizer st = new StringTokenizer(line, ",");
            Deque<Integer> deque = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            boolean reverse = false;
            boolean error = false;
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    reverse = !reverse;
                } else {
                    if (deque.size() == 0) {
                        error = true;
                        break;
                    }
                    if (!reverse) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }
            if (error) {
                System.out.println("error");
                continue;
            }
            StringBuilder output = new StringBuilder("[");
            if (!reverse) {
                while (!deque.isEmpty()) {
                    output.append(deque.removeFirst());
                    if(!deque.isEmpty()) {
                        output.append(",");
                    }
                }
            } else {
                while (!deque.isEmpty()) {
                    output.append(deque.removeLast());
                    if(!deque.isEmpty()) {
                        output.append(",");
                    }
                }
            }
            output.append("]");
            System.out.println(output);
        }
    }
}