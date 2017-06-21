package codility;

import java.util.Arrays;

class PermMissingElem {

    public int solution(int[] A) {
        // write your code in Java SE 8

        boolean occurred[] = new boolean[A.length + 2];

        for (int i = 0; i < A.length; i++) {
            int occurredNumber = A[i];
            occurred[occurredNumber] = true;
        }

        for (int i = 1; i < occurred.length; i++) {
            if (!occurred[i]) {
                return i;
            }
        }

        return A[A.length - 1];
    }

    public static void main(String[] args) {

        assertResult(new int[] {2, 3, 1, 5}, 4);
        assertResult(new int[] {}, 1);
        assertResult(new int[] {1}, 2);
        assertResult(new int[] {1, 2}, 3);
        assertResult(new int[] {1, 2, 3, 4, 5, 7}, 6);
        assertResult(new int[] {0, 2, 3, 4, 5, 6}, 1);
        assertResult(new int[] {0, 3, 4, 5, 6}, 1);
    }

    private static void assertResult(int[] A, int expected) {

        PermMissingElem s = new PermMissingElem();
        int actual = s.solution(A);
        if (actual != expected) {
            throw new RuntimeException("expected " + expected + " but " + actual + ". A=" + Arrays.toString(A));
        }
        System.out.println("Passed. A=" + Arrays.toString(A) + ", expected=" + expected);
    }
}