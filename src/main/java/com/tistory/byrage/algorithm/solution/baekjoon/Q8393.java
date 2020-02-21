package com.tistory.byrage.algorithm.solution.baekjoon;

import java.util.*;

public class Q8393 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        if (n % 2 == 0) {
            System.out.println((1 + n) * (n / 2));
        } else {
            n += 1;
            System.out.println((1 + n) * (n / 2) - n);
        }

        in.close(); /**/
    }

}
