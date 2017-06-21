package codility;

class BinaryGap {

    public int solution(int N) {

        final int MIN_N = 1;
        final int MAX_N = Integer.MAX_VALUE;

        if(N < MIN_N || N > MAX_N) return 0;

        int gap = 0;
        int tempGap = 0;
        boolean findFirst1Flag = false;

        int i = 1;
        while (N > i) {
            if ((N & i) == i) {
                findFirst1Flag = true;
                if (gap < tempGap) gap = tempGap;
                tempGap = 0;
            } else {
                if (findFirst1Flag) tempGap++;
            }

            N >>= 1;
        }

        if (gap < tempGap) gap = tempGap;

        return gap;
    }

    public static void main(String[] args) {

        BinaryGap s = new BinaryGap();
        assertResult(1041, 5);
        assertResult(9, 2);
        assertResult(529, 4);
        assertResult(20, 1);
        assertResult(1, 0);
//        assertResult(2147483647, 5);
    }

    public static void assertResult(int n, int expected) {

        BinaryGap s = new BinaryGap();
        int actual = s.solution(n);
        if (actual != expected) {
            throw new RuntimeException("expected " + expected + " but " + actual + ". n=" + n);
        }
        System.out.println("Passed. n=" + n + ", expected=" + expected);
    }
}