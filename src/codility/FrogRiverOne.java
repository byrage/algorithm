package codility;

import java.util.*;

class FrogRiverOne {

    public int solution(int X, int[] A) {

        // XX_RANGE[0] = MIN, XX_RANGE[1] = MAX
        final int[] N_RANGE = new int[] {0, 100000};
        final int[] X_RANGE = new int[] {0, 100000};
        final int[] E_RANGE = new int[] {1, X};

        // validation check
        if (N_RANGE[0] > A.length || A.length > N_RANGE[1]) return -1;
        if (X_RANGE[0] > X || X > N_RANGE[1]) return -1;

        Map<Integer, Integer> positionTimeMap = new HashMap<>();

        for (int i = A.length - 1; i >= 0; i--) {
            if (E_RANGE[0] > A[i] || A[i] > E_RANGE[1]) return -1;
            positionTimeMap.put(A[i], i);
        }

        int max = 0;

        for (int distance = 1; distance <= X; distance++) {
            Integer time = positionTimeMap.get(distance);
            if (time == null) {
                return -1;
            }

            if (max < time) {
                max = time;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        assertResult(4, new int[] {1, 2, 3, 1, 5}, -1);
        assertResult(4, new int[] {1, 2, 3, 1, 4}, 4);
        assertResult(2, new int[] {1, 2, 4, 1, 4}, -1);
        assertResult(2, new int[] {1, 3, 4, 1, 4}, -1);
        assertResult(2, new int[] {}, -1);
        assertResult(2, new int[] {1}, -1);
        assertResult(1, new int[] {1}, 0);
        assertResult(1, new int[] {-1}, -1);
        assertResult(1, new int[] {-1, -1}, -1);
        assertResult(2, new int[] {1, 2}, 1);
        assertResult(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}, 6);
        assertResult(5, new int[] {1, 3, 1, 2, 3, 5, 4}, 6);
    }

    private static void assertResult(int X, int[] A, int expected) {

        FrogRiverOne s = new FrogRiverOne();
        int actual = s.solution(X, A);
        if (actual != expected) {
            throw new RuntimeException("expected " + expected + " but " + actual + ". A=" + Arrays.toString(A));
        }
        System.out.println("Passed. A=" + Arrays.toString(A) + ", expected=" + expected);
    }
}