package codility;

class Task2 {

    public void solution(int[] A, int K) {

        // XX_RANGE[0] = MIN, XX_RANGE[1] = MAX
        final int[] N_RANGE = new int[] {1, 200};
        final int[] K_RANGE = new int[] {1, 1000000000};

        // validation check
        if (N_RANGE[0] > A.length || A.length > N_RANGE[1]) return;

        int maxDigit = 0;
        for (int i : A) {
            int tempDigit = calculateDigitNumber(i);

            if (maxDigit < tempDigit) {
                maxDigit = tempDigit;
            }
        }

        printTable(A, maxDigit, K);
        System.out.println();
    }

    private void printTable(int[] A, int maxDigit, int K) {

        int startIndex = 0;
        int endIndex = calculateEndIndex(A.length, K, startIndex);

        printDividingLine(maxDigit, endIndex - startIndex);

        while (true) {
            printNumber(A, maxDigit, startIndex, endIndex);
            printDividingLine(maxDigit, endIndex - startIndex);

            if (endIndex == A.length) { break; }

            startIndex = endIndex;
            endIndex = calculateEndIndex(A.length, K, startIndex);
        }

    }

    private void printNumber(int A[], int maxDigit, int startIndex, int endIndex) {

        System.out.println();
        System.out.print("|");

        for (int i = startIndex; i < endIndex; i++) {
            printSpace(A[i], maxDigit);
            System.out.print(A[i]);
            System.out.print("|");
        }
        System.out.println();
    }

    private void printSpace(int number, int maxDigit) {

        int space = maxDigit - calculateDigitNumber(number);
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
    }

    private void printDividingLine(int maxDigit, int cellCount) {

        System.out.print("+");

        for (int i = 0; i < cellCount; i++) {
            for (int j = 0; j < maxDigit; j++) {
                System.out.print("-");
            }

            System.out.print("+");
        }
    }

    private int calculateDigitNumber(int i) {

        int digit = 1;

        while (i >= 10) {
            if (i / 10 > 0) {
                digit++;
                i = i / 10;
            }
        }

        return digit;
    }

    private int calculateEndIndex(int length, int cellCount, int startIndex) {

        return startIndex + cellCount < length ? startIndex + cellCount : length;
    }

    public static void main(String[] args) {

//        assertResult(new int[] {4, 35, 80, 123, 12345, 44, 8, 5}, 10); // 8
//        assertResult(new int[] {4, 35, 80, 123, 12345, 44, 8, 5}, 4); // 4 + 4
//        assertResult(new int[] {4, 35, 80, 123, 12345, 44, 8, 5, 24, 3, 22, 35}, 4); // 4 + 4 + 4
//        assertResult(new int[] {4, 35, 80, 123, 12345, 44, 8, 5, 24, 3}, 4); // 4 + 4 + 2
//        assertResult(new int[] {1}, 4);
//        assertResult(new int[] {100000}, 4);
//        assertResult(new int[] {100001}, 4);

//        assertCalculateDigitNumber(1, 1);
//        assertCalculateDigitNumber(10, 2);
//        assertCalculateDigitNumber(123, 3);
    }

    private static void assertResult(int[] A, int K) {

        Task2 s = new Task2();
        s.solution(A, K);
    }

    private static void assertCalculateDigitNumber(int number, int expected) {

        Task2 s = new Task2();
        int actual = s.calculateDigitNumber(number);
        if (actual != expected) {
            throw new RuntimeException("expected " + expected + " but " + actual + ".");
        }
    }
}