package coderpad;

/*
 * {3, 1, 4} => 314
 * {1} => 1
 * {} => 0
 */

public class Task1 {

    public static void main(String[] args) {

        System.out.println(solution(new int[] {3, 1, 4}));
        System.out.println(solution(new int[] {1}));
        System.out.println(solution(new int[] {}));
    }

    static int solution(int[] arr) {

        int result = 0;

        for (int i : arr) {
            result = result * 10 + i;
        }

        return result;
    }
}
