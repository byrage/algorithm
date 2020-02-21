package com.tistory.byrage.algorithm.solution.codility;

class Task3 {

    public int solution(String S) {

        // XX_RANGE[0] = MIN, XX_RANGE[1] = MAX
        final int[] N_RANGE = new int[] {1, 200};
        final int INVALID_PASSWORD = -1;

        // validation check
        if (N_RANGE[0] > S.length() || S.length() > N_RANGE[1]) return INVALID_PASSWORD;

        char[] charArr = S.toCharArray();
        boolean isContainUpper = false;

        for (char c : charArr) {
            if (isUpperAlpha(c)) {
                isContainUpper = true;
                break;
            }
        }

        if (!isContainUpper) {
            return INVALID_PASSWORD;
        }

        int maxLength = 0;
        int length = 0;
        for (char c : charArr) {
            if (isAlpha(c)) {
                length++;
            } else {
                maxLength = max(maxLength, length);
                length = 0;
            }
        }

        maxLength = max(maxLength, length);

        return maxLength;
    }

    private int max(int x, int y) {

        return x < y ? y : x;
    }

    private boolean isAlpha(char c) {

        return isLowerAlpha(c) || isUpperAlpha(c);
    }

    private boolean isUpperAlpha(char c) {

        return (c >= 'A' && c <= 'Z');
    }

    private boolean isLowerAlpha(char c) {

        return (c >= 'a' && c <= 'z');
    }

    public static void main(String[] args) {

        assertResult("a0Ba", 2);
        assertResult("a0ba", -1);
        assertResult("A0BA", 2);
        assertResult("AAA", 3);
        assertResult("aaa", -1);
        assertResult("zzz", -1);
        assertResult("a0b0a0B", 1);
        assertResult("aaa0b0a0B", 3);
        assertResult("ZZZZZZZXXX", 10);
        assertResult("A", 1);
        assertResult("a", -1);
        assertResult("0", -1);
        assertResult("Bao0a3", 3);
        assertResult("1234", -1);
        assertResult("aaaaAaa", 7);

//        parameter only alphanumerical characters
//        assertResult("테스트", -1);
//        assertResult("테스트123", -1);
//        assertResult("테스트A123", 1);
//        assertResult("B 123 1 A", 1);
//        assertResult("", -1);
//        assertResult("  ", -1);
//        assertResult(" a ", -1);
//        assertResult(" A ", 1);
    }

    private static void assertResult(String S, int expected) {

        Task3 s = new Task3();
        int actual = s.solution(S);
        if (actual != expected) {
            throw new RuntimeException("expected " + expected + " but " + actual + ".");
        }
        System.out.println("Passed. S=" + S + ", expected=" + expected);
    }
}