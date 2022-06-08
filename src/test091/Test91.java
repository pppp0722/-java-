package test091;
// 프로그래머스/Level3/[1차] 추석 트래픽

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test91 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] lines = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
            "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
            "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s",
            "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
            "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
        int answer = solution.solution(lines);
        System.out.println(answer);
    }
}

class Solution {

    public int solution(String[] lines) {
        List<Work> works = new ArrayList<>();

        for (String line : lines) {
            String[] splitLine = line.split(" ");
            double[] endTimeArr = Arrays.stream(splitLine[1].split(":"))
                .mapToDouble(Double::parseDouble)
                .toArray();
            int endTime = 0;
            for (int i = 0; i < 3; i++) {
                endTime += (int) (endTimeArr[i] * Math.pow(60, 2 - i) * 1000);
            }
            int workTime = (int) (
                Double.parseDouble(splitLine[2].substring(0, splitLine[2].length() - 1)) * 1000);
            int startTime = endTime - workTime + 1;
            works.add(new Work(startTime, endTime));
        }

        int max = 0;
        for (Work work : works) {
            int num1 = 0;
            int num2 = 0;
            for (Work compWork : works) {
                if (check(work.getStartTime(), compWork)) {
                    num1++;
                }
                if (check(work.getEndTime(), compWork)) {
                    num2++;
                }
            }
            if (Math.max(num1, num2) > max) {
                max = Math.max(num1, num2);
            }
        }

        return max;
    }

    public boolean check(int time, Work work) {
        int startTime = work.getStartTime();
        int endTime = work.getEndTime();
        if (startTime >= time && startTime <= time + 999) {
            return true;
        } else if (endTime >= time && endTime <= time + 999) {
            return true;
        } else if (startTime < time && endTime > time + 999) {
            return true;
        }

        return false;
    }
}

class Work {

    private final int startTime;
    private final int endTime;

    public Work(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}