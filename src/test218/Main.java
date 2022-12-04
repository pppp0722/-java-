package test218;
// 그리디/백준/골드1/1700 멀티탭 스케줄링

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] orderOfUse = new int[k];
        Set<Integer> powerSocket = new HashSet<>();
        line = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            orderOfUse[i] = Integer.parseInt(line[i]);
        }

        // 그리디
        int answer = 0;
        for (int i = 0; i < k; i++) {
            int item = orderOfUse[i];

            // 이미 꽂혀있으면 continue
            if (powerSocket.contains(item)) {
                continue;
            }

            if (powerSocket.size() < n) { // 꽂을 구멍 있으면 넣기
                powerSocket.add(item);
            } else { // 사용하지 않을 아이템 우선 뽑기, 모두 사용하면 가장 늦게 사용하는 아이템 뽑기
                int maxIdx = 0;
                boolean hasNoUseItem = false;
                for (int pluggedItem : powerSocket) {
                    boolean exists = false;
                    for (int j = i + 1; j < k; j++) {
                        if (orderOfUse[j] == pluggedItem) {
                            maxIdx = Math.max(j, maxIdx);
                            exists = true;
                            break;
                        }
                    }

                    if (!exists) {
                        hasNoUseItem = true;
                        powerSocket.remove(pluggedItem);
                        powerSocket.add(item);
                        break;
                    }
                }

                if (!hasNoUseItem) {
                    powerSocket.remove(orderOfUse[maxIdx]);
                    powerSocket.add(item);
                }

                answer++;
            }
        }

        System.out.println(answer);
    }
}
