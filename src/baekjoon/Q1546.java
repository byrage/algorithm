package baekjoon;

import java.util.*;

public class Q1546 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int cnt = in.nextInt();
        float max = 0;
        float sum = 0;

        for (int i = 0; i < cnt; i++) {
            int temp = in.nextInt();
            sum += temp;
            if (temp > max) max = temp;
        }

        System.out.printf("%.2f", sum / max * 100 / cnt);

        in.close(); /**/
    }
}

