package baekjoon;

import java.util.Scanner;

public class Q1065 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int limit = in.nextInt();
        int cnt = 0;

        for (int i = 1; i <= limit; i++) {
            if (isSeries(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
        in.close(); /**/
    }

    private static boolean isSeries(int num) {

        if (num > 0 && num < 100) return true;

        int d = (num % 10) - (num / 10 % 10);
        num /= 10;
        while (num >= 10) {
            if (d != (num % 10) - (num / 10 % 10)) return false;
            num /= 10;
        }

        return true;
    }
}

