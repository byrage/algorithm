package com.tistory.byrage.algorithm.solution.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StructureOperator {

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataStructure dataStructure = new DataStructure();
        while (true) {
            String input = br.readLine();
            if (input.startsWith("evict")) {
                dataStructure.evict();
            }
            if (input.startsWith("add")) {
                String[] arguments = input.split("\\s");
                dataStructure.add(Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]));
            }
            if (input.startsWith("get")) {
                String[] arguments = input.split("\\s");
                Integer result = dataStructure.get(Integer.parseInt(arguments[1]));
                System.out.println(result);
            }
            if (input.startsWith("remove")) {
                String[] arguments = input.split("\\s");
                Integer result = dataStructure.remove(Integer.parseInt(arguments[1]));
                System.out.println(result);
            }
            if (input.startsWith("exit")) {
                return;
            }
        }
    }

    public static class DataStructure {

        private static final Integer NOT_EXISTS_VALUE = -1;

        private final Map<Integer, Integer> structure = new HashMap<>();
        private Integer recentUsedKey;

        public void evict() {
            structure.keySet().stream()
                    .filter(key -> !key.equals(recentUsedKey))
                    .collect(Collectors.toSet())
                    .forEach(structure::remove);
        }

        public void add(Integer key, Integer value) {
            structure.put(key, value);
            saveRecentUsedKey(key);
        }

        public Integer get(Integer key) {
            Integer getValue = structure.getOrDefault(key, NOT_EXISTS_VALUE);
            saveRecentUsedKey(key);
            return getValue;
        }

        public Integer remove(Integer key) {
            boolean isExists = structure.keySet()
                    .stream()
                    .anyMatch(existsKey -> existsKey.equals(key));
            if (isExists) {
                return structure.remove(key);
            }
            return NOT_EXISTS_VALUE;
        }

        private void saveRecentUsedKey(Integer key) {
            recentUsedKey = key;
        }
    }
}
