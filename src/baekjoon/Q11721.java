package baekjoon;

import java.util.Scanner;

public class Q11721 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String word = in.next();

        for (int i = 1; i <= word.length(); i++) {
            System.out.print(word.charAt(i - 1));
            if (i % 10 == 0) System.out.println();
        }

        in.close(); /**/
    }
}
