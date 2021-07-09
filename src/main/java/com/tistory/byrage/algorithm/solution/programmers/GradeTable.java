package com.tistory.byrage.algorithm.solution.programmers;

import java.util.*;

public class GradeTable {

    public static void main(String[] args) {
        GradeTable gradeTable = new GradeTable();
        String[] result = gradeTable.solution(
                new String[] {"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+",
                        "OS1808 B-", "DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0", "DM0106 D-", "PL6677 B+",
                        "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0", "DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0"});
        System.out.println(Arrays.toString(result));
    }

    public String[] solution(String[] grades) {
        Map<String, Score> table = new HashMap<>();
        for (String grade : grades) {
            String[] splitGrade = grade.split("\\s");
            String number = splitGrade[0];
            Score score = new Score(splitGrade[1]);
            if (table.containsKey(number)) {
                Score existScore = table.get(number);
                table.put(number, existScore.computeGreaterScore(score));
            } else {
                table.put(number, score);
            }
        }

        return sortTable(table)
                .entrySet()
                .stream()
                .map(entry -> String.format("%s %s", entry.getKey(), entry.getValue()))
                .toArray(String[]::new);
    }

    private static Map<String, Score> sortTable(Map<String, Score> table) {
        List<Map.Entry<String, Score>> entries = new LinkedList<>(table.entrySet());
        entries.sort((o1, o2) -> o1.getValue().getGradeScore() >= o2.getValue().getGradeScore() ? 1 : -1);

        Map<String, Score> result = new LinkedHashMap<>();
        entries.forEach(entry -> result.put(entry.getKey(), entry.getValue()));
        return result;
    }

    static class Score {

        private final String grade;

        public Score(String grade) {
            this.grade = grade;
        }

        public Score computeGreaterScore(Score score) {
            return this.getGradeScore() < score.getGradeScore() ? this : score;
        }

        public int getGradeScore() {
            char[] chars = grade.toCharArray();
            int gradeScore = (chars[0] - 'A') * 10;
            if (chars.length == 1) {
                return gradeScore;
            }
            gradeScore += chars[1] == '+' ? 1 : chars[1] == '0' ? 2 : 3;
            return gradeScore;
        }

        @Override
        public String toString() {
            return grade;
        }
    }
}
