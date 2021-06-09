package com.tistory.byrage.algorithm.solution.leetcode.arrays101;

public class MaxConsecutiveOne {

    public static void main(String[] args){
        Solution solution = new Solution();
        int result = solution.findMaxConsecutiveOnes(new int[] {1, 0, 1, 1, 0, 1});
        System.out.println(result);
    }

    static class Solution {

        public int findMaxConsecutiveOnes(int[] nums) {
            int consecutive = 0;
            int temp = 0;
            for (int num : nums) {
                if (num == 0) {
                    temp = 0;
                } else {
                    temp++;
                }

                if (consecutive < temp) {
                    consecutive = temp;
                }
            }
            return consecutive;
        }
    }
}
