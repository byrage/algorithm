package codility;

import java.util.Arrays;

class Template {

    int solution(int[] A) {

        // XX_RANGE[0] = MIN, XX_RANGE[1] = MAX
        final int[] N_RANGE = new int[] {0, 100000};

        // validation check
        if (N_RANGE[0] > A.length || A.length > N_RANGE[1]) return 0;
        if (N_RANGE[0] == A.length) return 0;

        return 0;
    }

    public static void main(String[] args) {

        assertResult(new int[]{2, 3, 1, 5}, 4);
    }

    private static void assertResult(int[] A, int expected) {

        Template s = new Template();
        int actual = s.solution(A);
        if (actual != expected) {
            throw new RuntimeException("expected " + expected + " but " + actual + ". A=" + Arrays.toString(A));
        }
        System.out.println("Passed. A=" + Arrays.toString(A) + ", expected=" + expected);
    }
}