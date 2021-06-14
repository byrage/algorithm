package com.tistory.byrage.algorithm.solution.programmers;

public class StringAdder {

    public static void main(String[] args) {
        StringAdder stringAdder = new StringAdder();
//        String result = stringAdder.solution("102", "989");
//        String result = stringAdder.solution("11", "9");
        String result = stringAdder.solution("2813928498324982342494239423890442423", "999199328448234399938449840038934324328");
        System.out.println(result);
    }

    public String solution(String a, String b) {
        StringBuilder answer = new StringBuilder();
        int max = a.length() >= b.length() ? a.length() : b.length();
        String paddingA = "";
        String paddingB = "";
        if (a.length() < max) {
            for (int i = 0; i < max - a.length(); i++) {
                paddingA += "0";
            }
        }
        paddingA += a;
        if (b.length() < max) {
            for (int i = 0; i < max - b.length(); i++) {
                paddingB += "0";
            }
        }
        paddingB += b;
        int carry = 0;
        char[] charsA = paddingA.toCharArray();
        char[] charsB = paddingB.toCharArray();

        for (int i = max - 1; i >= 0; i--) {
            int valueA = charsA.length > i ? charsA[i] - '0' : 0;
            int valueB = charsB.length > i ? charsB[i] - '0' : 0;
            int sum = valueA + valueB + carry;
            carry = sum / 10;
            answer.append(sum % 10);
        }
        if (carry == 1) {
            answer.append(carry);
        }
        return answer.reverse().toString();
    }
}
