package com.tistory.byrage.algorithm.solution.baekjoon;

import java.util.Scanner;

public class Q11720 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int cnt = in.nextInt();
        String number = in.next();

        int result = 0;
        for (char c : number.toCharArray()) {
            result += c - '0';
        }

        System.out.println(result);

        in.close(); /**/
    }
}
