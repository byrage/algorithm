package com.tistory.byrage.algorithm.solution.programmers;

import java.util.stream.LongStream;

public class SumCalculator {

    public static void main(String[] args) {
        SumCalculator sumCalculator = new SumCalculator();
        long answer = sumCalculator.solution(5, 3);
        System.out.println(answer);
    }

    public long solution(int a, int b) {

        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return LongStream.rangeClosed(min, max)
                .sum();
    }
}
