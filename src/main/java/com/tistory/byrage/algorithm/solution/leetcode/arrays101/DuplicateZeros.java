package com.tistory.byrage.algorithm.solution.leetcode.arrays101;

import java.util.ArrayList;
import java.util.List;

public class DuplicateZeros {

    class Solution {

        public void duplicateZeros(int[] arr) {
            List<Integer> temp = new ArrayList<>();
            for (int i : arr) {
                temp.add(i);
                if (i == 0) {
                    temp.add(0);
                }
                if (temp.size() == arr.length) {
                    break;
                }
            }
            System.arraycopy(temp.stream().mapToInt(i -> i).toArray(), 0, arr, 0, arr.length);
        }
    }
}
