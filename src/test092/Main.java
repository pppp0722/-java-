package test092;
// 백준/골드1/21611번 마법사 상어와 블리자드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static final int UP = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static final int RIGHT = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int N = size[0];
        int M = size[1];
        int userIdx = N / 2;

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            matrix[i] = row;
        }
        matrix[userIdx][userIdx] = -1;

        int[][] blizzards = new int[M][2];
        for (int i = 0; i < M; i++) {
            int[] blizzard = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            blizzards[i] = blizzard;
        }

        int answer = 0;
        for (int[] blizzard : blizzards) {
            blizzard(matrix, userIdx, blizzard[0], blizzard[1]);
            List<Integer> list = matrixToList(matrix, userIdx);
            answer += boom(list);
            list = change(N, list);
            matrix = listToMatrix(list, N, userIdx);
        }

        System.out.println(answer);
    }

    public static List<Integer> matrixToList(int[][] matrix, int userIdx) {
        List<Integer> list = new ArrayList<>();
        int curX = userIdx;
        int curY = userIdx;
        int dir = LEFT;
        int length = 1;
        int move = 0;
        int corner = 0;
        while (curX != 0 || curY != -1) {
            list.add(matrix[curX][curY]);

            if (move == length) {
                dir = dirChange(dir);
                corner++;
                move = 0;
            }

            if (corner == 2) {
                length++;
                corner = 0;
            }

            switch (dir) {
                case UP:
                    curX--;
                    break;
                case DOWN:
                    curX++;
                    break;
                case LEFT:
                    curY--;
                    break;
                default:
                    curY++;
                    break;
            }

            move++;
        }

        list.removeAll(Collections.singletonList(0));
        return list;
    }

    public static int[][] listToMatrix(List<Integer> list, int N, int userIdx) {
        int[][] matrix = new int[N][N];
        int curX = userIdx;
        int curY = userIdx;
        int dir = LEFT;
        int length = 1;
        int move = 0;
        int corner = 0;
        for (int i = 0; i < list.size(); i++) {
            matrix[curX][curY] = list.get(i);

            if (move == length) {
                dir = dirChange(dir);
                corner++;
                move = 0;
            }

            if (corner == 2) {
                length++;
                corner = 0;
            }

            switch (dir) {
                case UP:
                    curX--;
                    break;
                case DOWN:
                    curX++;
                    break;
                case LEFT:
                    curY--;
                    break;
                default:
                    curY++;
                    break;
            }

            move++;
        }

        return matrix;
    }

    public static void blizzard(int[][] matrix, int userIdx, int dir, int range) {
        for (int i = 1; i <= range; i++) {
            switch (dir) {
                case UP:
                    matrix[userIdx - i][userIdx] = 0;
                    break;
                case DOWN:
                    matrix[userIdx + i][userIdx] = 0;
                    break;
                case LEFT:
                    matrix[userIdx][userIdx - i] = 0;
                    break;
                default:
                    matrix[userIdx][userIdx + i] = 0;
                    break;
            }
        }
    }

    public static int dirChange(int dir) {
        switch (dir) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            default:
                return UP;
        }
    }

    public static int boom(List<Integer> list) {
        int totalScore = 0;
        while (true) {
            int score = 0;
            int same = 1;
            int lastNum = 0;
            int curNum;
            for (int i = list.size() - 1; i >= 0; i--) {
                curNum = list.get(i);
                if (curNum == lastNum) {
                    same++;
                } else {
                    if (same >= 4) {
                        score += lastNum * same;
                        list.subList(i + 1, i + same + 1).clear();
                    }
                    same = 1;
                }
                lastNum = curNum;
            }

            if (score == 0) {
                break;
            }

            totalScore += score;
        }

        return totalScore;
    }

    public static List<Integer> change(int N, List<Integer> list) {
        int curNum;
        int lastNum = list.get(list.size() - 1);
        int same = 1;
        for (int i = list.size() - 2; i >= 0; i--) {
            curNum = list.get(i);
            if (curNum == lastNum) {
                same++;
            } else {
                if (same == 1) {
                    list.add(i + 2, lastNum);
                    list.set(i + 1, same);
                } else if (same == 2) {
                    list.set(i + 2, lastNum);
                    list.set(i + 1, same);
                } else {
                    list.remove(i + 3);
                    list.set(i + 2, lastNum);
                    list.set(i + 1, same);
                }

                same = 1;
            }

            lastNum = curNum;
        }

        int maxSize = N * N;
        return list.size() > maxSize ? new ArrayList<>(list.subList(0, maxSize)) : list;
    }
}