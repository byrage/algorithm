package com.tistory.byrage.algorithm.solution.programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Add2Number {

    public boolean solution(int[] arr, int n) {
        List<Integer> integers = Arrays.stream(arr)
                .filter(element -> element <= n)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < integers.size() - 1; i++) {
            for (int j = i + 1; j < integers.size(); j++) {
                if (integers.get(i) + integers.get(j) > n) {
                    break;
                }
                if (integers.get(i) + integers.get(j) == n) {
                    return true;
                }
            }
        }
        return false;
    }
}
