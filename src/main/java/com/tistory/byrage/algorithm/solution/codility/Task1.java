package com.tistory.byrage.algorithm.solution.codility;

import java.util.Arrays;

class Task1 {

    public int solution(int[] A) {

        // XX_RANGE[0] = MIN, XX_RANGE[1] = MAX
        final int[] N_RANGE = new int[] {0, 200000};
        final int[] E_RANGE = new int[] {-1, A.length - 1};
        final int LAST_VALUE = -1;

        if (N_RANGE[0] > A.length || A.length > N_RANGE[1]) return 0;
        if (A.length == N_RANGE[0]) return 0;

        int length = 1;
        int value = A[0];

        while (value != LAST_VALUE) {
            if (E_RANGE[0] > A[value] || A[value] > E_RANGE[1]) {
                return length;
            }

            value = A[value];
            length++;
        }

        return length;
    }

    public static void main(String[] args) {

        assertResult(new int[] {1, 4, -1, 3, 2}, 4);
        assertResult(new int[] {}, 0);
        assertResult(new int[] {-1}, 1);
        assertResult(new int[] {1, -1}, 2);
        assertResult(new int[] {1, 200000}, 1);
        assertResult(new int[] {1, 200001}, 1);
        assertResult(new int[] {2, 0, 3, -1}, 3);
    }

    private static void assertResult(int[] A, int expected) {

        Task1 s = new Task1();
        int actual = s.solution(A);
        if (actual != expected) {
            throw new RuntimeException("expected " + expected + " but " + actual + ". A=" + Arrays.toString(A));
        }
        System.out.println("Passed. A=" + Arrays.toString(A) + ", expected=" + expected);
    }
}