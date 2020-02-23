package com.tistory.byrage.algorithm.solution.programmers.step1;

import java.util.*;

public class MarkRandom {

    public static void main(String[] args) {
        MarkRandom markRandom = new MarkRandom();
        int[] solution = markRandom.solution(new int[] {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5});
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] answers) {

        List<Integer> answer = new ArrayList<>();

        int score1 = answer1(answers);
        int score2 = answer2(answers);
        int score3 = answer3(answers);

        int max = Math.max(Math.max(score1, score2), score3);

        if (score1 == max) {
            answer.add(1);
        }

        if (score2 == max) {
            answer.add(2);
        }
        if (score3 == max) {
            answer.add(3);
        }

        int[] a = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            a[i] = answer.get(i);
        }

        return a;
    }

    public int answer1(int[] answers) {

        int score = 0;
        int mark = 1;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == mark) {
                score++;
            }
            mark = mark % 5;
            mark++;
        }

        return score;
    }

    public int answer2(int[] answers) {
        int score = 0;
        int mark = 1;

        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0) {
                if (answers[i] == 2) {
                    score++;
                }
            }

            if (i % 2 == 1) {
                if (answers[i] == mark) {
                    score++;
                }
                mark = mark % 5;
                mark++;
            }
        }
        return score;
    }

    private int answer3(int[] answers) {

        /**
         * 0, 1 -> 0
         * 2, 3 -> 1
         * 4, 5 -> 2
         */
        int score = 0;
        List<Integer> markPattern = Arrays.asList(3, 1, 2, 4, 5);

        for (int i = 0; i < answers.length; i++) {
            int markIndex = i / 2 % 5;
            if (answers[i] == markPattern.get(markIndex)) {
                score++;
            }
        }
        return score;
    }
}
