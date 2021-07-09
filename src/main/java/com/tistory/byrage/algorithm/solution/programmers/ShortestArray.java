package com.tistory.byrage.algorithm.solution.programmers;

public class ShortestArray {

    public static void main(String[] args) {
        ShortestArray array = new ShortestArray();
        System.out.println(array.solution(new int[] {1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 20));
    }

    public int solution(int[] A, int S) {
        int minSum = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (S <= sum) {
                    int currentLength = j - i + 1;
                    if (minSum > sum) {
                        minSum = sum;
                        answer = currentLength;
                    }
                    if (minSum == sum && answer > currentLength) {
                        answer = currentLength;
                    }
                    break;
                }
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
