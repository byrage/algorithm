package com.tistory.byrage.algorithm.solution.baekjoon;

public class Q4673 {

    // 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);

        boolean[] isSelfNum = new boolean[100001];
        for (int i = 1; i <= 10000; i++) {
            int index = selfNum(i);
            isSelfNum[index] = true;
        }

        for (int i = 1; i <= 10000; i++) {
            if (!isSelfNum[i]) {
                System.out.println(i);
            }
        }

//        in.close(); /**/
    }

    private static int selfNum(int i) {

        int result = i + (i % 10);
        int temp = i;
        while (temp / 10 > 0) {
            temp /= 10;
            result += temp % 10;
        }

        return result;
    }

}
