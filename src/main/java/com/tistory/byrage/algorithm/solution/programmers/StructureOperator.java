package com.tistory.byrage.algorithm.solution.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
Description
문제
다음과 같은 Operation을 사용할 수 있는 자료구조를 구현하시오

// assume Integer provides good hashCode()
void evict(); // add나 get된지 오래된 항목을 자료구조에서 제거
void add(Integer key, Integer value); // 자료구조에 key, value에 해당하는 항목을 추가한다.
Integer get(Integer key); // key에 해당하는 항목을 찾아 그 value를 반환. 항목이 없는 경우 Exception
Integer remove(Integer key); // key에 해당하는 항목을 찾아 그 value를 반환하고 항목을 자료구조에서 제거. 항목이 없는 경우 Exception
편의를 위해, 이 문제에서는 Integer, Integer 모두 230 이하의 자연수라고 가정해도 좋다.

입력
입력의 각 줄은 자료구조를 조작하는 명령을 나타낸다. 각 명령에 파라메터가 있는 경우 명령어 뒤에 공백으로 구분하여 파라메터가 전달 된다. (정의 되지 않은 명령어가 입력 되면 무시하고 새로운 명령을 입력 받는다.)

evict : 위에 설명된 evict operation을 수행한다.
add : 위에 설명된 add operation을 수행한다. 인자의 첫번째는 key, 두번째는 value를 나타낸다.
get : 첫번째 인자의 값을 key로 사용하여 위에 설명된 get operation을 수행한다. 획득한 결과를 출력한다. 항목이 없거나 예외가 발생 되는 경우 '-1'을 출력 한다.
remove : 첫번째 인자의 값을 key로 사용해서 remove operation을 수행한다. 획득한 결과를 출력한다. 항목이 없거나 예외가 발생 되는 경우 '-1'을 출력 한다.
exit : 더 이상 새로운 입력을 받지 않고 결과를 출력 하고 종료한다.
아래와 같은 형태로 입력 값이 전달 될 수 있다.

add 5 3
add 1 2
get 5
evict
get 1
remove 5
exit
출력
명령어 처리 결과를 출력한다. 결과의 한줄에 하나의 명령의 처리 결과가 표현 된다.
위의 입력 예제에서는 아래와 같은 결과가 출력 될 수 있다.

3
-1
3
 */
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
