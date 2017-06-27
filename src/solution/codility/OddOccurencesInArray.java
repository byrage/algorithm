package solution.codility;

import java.util.HashMap;
import java.util.Map;

class OddOccurencesInArray {

    int solution(int[] A) {

        final int MIN_N = 1;
        final int MAX_N = 1000000;

        final int MIN_E = 1;
        final int MAX_E = 1000000000;

        if (A.length < MIN_N || A.length > MAX_N) { return 0; } // N range check
        if (A.length == 1) return A[0];

        Map<Integer, Boolean> pairedMap = new HashMap<>();
        for (int i : A) {

            if (i < MIN_E || i > MAX_E) {
                return i;
            }

            Boolean paired = pairedMap.get(i);
            if (paired == null) {
                pairedMap.put(i, false);
            } else {
                pairedMap.put(i, true);
            }
        }

        return fetchNotPairedValueInMap(pairedMap);
    }

    private int fetchNotPairedValueInMap(Map<Integer, Boolean> pairedMap) {

        for (Map.Entry<Integer, Boolean> entry : pairedMap.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        assertResult(new int[] {9, 3, 9, 3, 9, 7, 9}, 7);
        assertResult(new int[] {1, 3, 1, 3, 1, 3, 1, 3, 5}, 5);
        assertResult(new int[] {1}, 1);
        assertResult(new int[] {-1}, -1);
        assertResult(new int[] {1000000000}, 1000000000);
        assertResult(new int[] {1, 5, 1, 5, 3}, 3);
        assertResult(new int[] {3, 5, 1, 5, 1}, 3);
        assertResult(new int[] {42}, 42);
        assertResult(new int[] {2, 2, 3, 3, 4}, 4);
        assertResult(new int[] {2, 2, 3, 3, 4, 4}, 0);
    }

    private static void assertResult(int[] n, int expected) {

        OddOccurencesInArray s = new OddOccurencesInArray();
        int actual = s.solution(n);
        if (actual != expected) {
            throw new RuntimeException("expected " + expected + " but " + actual + ". n=" + n);
        }
        System.out.println("Passed. n=" + n + ", expected=" + expected);
    }
}