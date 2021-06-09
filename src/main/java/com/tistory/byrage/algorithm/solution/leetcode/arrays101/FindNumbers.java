package com.tistory.byrage.algorithm.solution.leetcode.arrays101;

public class FindNumbers {

    class Solution {

        public int findNumbers(int[] nums) {
            int even = 0;
            for (int num : nums) {
                String str = String.valueOf(num);
                if (str.length() % 2 == 0) {
                    even++;
                }
            }
            return even;
        }
    }
}
