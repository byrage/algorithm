package com.tistory.byrage.algorithm.solution.baekjoon;

import java.util.Scanner;

public class Q2440 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = n; i > 0; i--) {
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
