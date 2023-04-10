package test190;
// 트리맵/백준/골드4/7662 이중 우선순위 큐

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                String[] line = br.readLine().split(" ");
                char command = line[0].charAt(0);
                int num = Integer.parseInt(line[1]);

                if (command == 'I') {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else if (!treeMap.isEmpty()) {
                    int key = num == 1 ? treeMap.lastKey() : treeMap.firstKey();
                    treeMap.put(key, treeMap.get(key) - 1);
                    if (treeMap.get(key) == 0) {
                        treeMap.remove(key);
                    }
                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey());
            }
            sb.append(lineSeparator());
        }

        System.out.println(sb);
    }
}
