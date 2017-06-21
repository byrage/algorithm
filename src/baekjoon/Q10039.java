package baekjoon;

import java.util.Scanner;

public class Q10039 {

    public static void main(String[] args) {
        final int student_count = 5;

        float sum = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < student_count; i++) {
            int score = scanner.nextInt();
            sum += score < 40 ? 40 : score;
        }

        System.out.println((int)sum / 5);
    }
}
