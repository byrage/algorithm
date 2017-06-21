package baekjoon;

import java.util.*;

public class Q4344 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int testCnt = in.nextInt();
        float[] overAverageRatios = new float[testCnt];
        for (int i = 0; i < testCnt; i++) {
            int studentCnt = in.nextInt();

            int[] scores = new int[studentCnt];
            float sum = 0;
            for (int j = 0; j < studentCnt; j++) {
                scores[j] = in.nextInt();
                sum += scores[j];
            }

            sum /= studentCnt;
            float overAverage = 0;
            for (int j = 0; j < studentCnt; j++) {
                if (scores[j] > sum) overAverage++;
            }

            overAverageRatios[i] = overAverage / studentCnt * 100;
        }

        for (int i = 0; i < testCnt; i++) {
            System.out.printf("%.3f%%\n", overAverageRatios[i]);
        }

        in.close(); /**/
    }
}