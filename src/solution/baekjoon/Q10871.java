package solution.baekjoon;

import java.util.Scanner;

public class Q10871 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int cnt = in.nextInt();
        int standard = in.nextInt();

        for (int i = 0; i < cnt; i++) {
            int temp = in.nextInt();
            if (temp < standard) {
                System.out.print(temp + " ");
            }
        }

        in.close(); /**/
    }
}
