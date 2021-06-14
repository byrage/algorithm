package com.tistory.byrage.algorithm.solution.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReverseString {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();

        List<String> lines = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(input); i++) {
            lines.add(br.readLine());
        }

        for (String line : lines) {
            String[] eachWords = line.split("\\s");
            for (String eachWord : eachWords) {
                char[] chars = eachWord.toCharArray();
                for (int j = chars.length - 1; j >= 0; j--) {
                    System.out.print(chars[j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
