package solution.codility;

import java.util.Arrays;

class CyclicRotation {

    public int[] solution(int[] A, int K) {

        // XX_RANGE[0] = MIN, XX_RANGE[1] = MAX
        final int[] N_RANGE = new int[] {0, 100};
        final int[] K_RANGE = new int[] {0, 100};
        final int[] ELEMENT_RANGE = new int[] {-1000, 1000};

        if (N_RANGE[0] > A.length || A.length > N_RANGE[1]) return null;
        if (N_RANGE[0] == A.length) return A;
        if (K_RANGE[0] > K || K > K_RANGE[1]) return null;
        if (K > A.length) K = K % A.length;

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int index = (A.length + i - K) % A.length;
            result[i] = A[index];
        }

        return result;
    }

    public static void main(String[] args) {

        assertResult(new int[] {3, 8, 9, 7, 6}, 3, new int[] {9, 7, 6, 3, 8});
        assertResult(new int[] {3, 8, 9, 7, 6}, 6, new int[] {6, 3, 8, 9, 7});
        assertResult(new int[] {3, 8, 9, 7}, 3, new int[] {8, 9, 7, 3});
        assertResult(new int[] {3, 8, 2}, 3, new int[] {3, 8, 2});
        assertResult(new int[] {3, 8, 2}, 1, new int[] {2, 3, 8});
        assertResult(new int[] {}, 1, new int[] {});
    }

    public static void assertResult(int[] A, int k, int[] expected) {

        CyclicRotation s = new CyclicRotation();
        int[] actual = s.solution(A, k);
//        if (actual != expected) {
//            throw new RuntimeException("expected " + Arrays.toString(expected) + " but " + Arrays.toString(actual) + ". A=" + A);
//        }
        if (!Arrays.equals(actual, expected)) {
            throw new RuntimeException("expected " + Arrays.toString(expected) + " but " + Arrays.toString(actual) + ". A=" + A);
        }

        System.out.println("Passed. A=" + Arrays.toString(A) + ", expected=" + Arrays.toString(expected));
    }
}