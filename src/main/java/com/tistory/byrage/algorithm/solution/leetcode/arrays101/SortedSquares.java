package com.tistory.byrage.algorithm.solution.leetcode.arrays101;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntFunction;

public class SortedSquares {

    class Solution {

        public int[] sortedSquares(int[] nums) {
            List<Integer> squared = new ArrayList<>();
            for (int num : nums) {
                squared.add(num * num);
            }
            squared.sort(Comparator.naturalOrder());
            return squared.stream()
                    .mapToInt(i -> i)
                    .toArray();
        }
    }
}
