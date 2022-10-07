package test194;
// 백준/실버4/1920 수 찾기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // not use
        Set<Integer> set = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
        br.readLine(); // not use
        Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .map(i -> set.contains(i) ? 1 : 0)
            .forEach(System.out::println);
    }
}
