package solution.coderpad;

/*
 * Write a function bool isRotation(int[] first, int[] second) that checks
 * if the second is a rotation of first.
 * Assume first and second are not null and same size.
 *
 * For example, given first array [1,2,3,1,5],
 *
 * - [3, 1, 5, 1, 2] is a rotation,
 * - [2, 1, 3, 1, 5] is not a rotation,
 * - [5, 1, 3, 2, 1] is not a rotation.
 *
 * Time complexity should be O(n^2).
 * Do not create any new array.
 *
 */

public class Task2 {

    public static void main(String[] args) {

        int[] first = new int[] {1, 2, 3, 1, 5};

        // success case
        System.out.println(isRotation(first, new int[] {1, 2, 3, 1, 5}));
        System.out.println(isRotation(first, new int[] {2, 3, 1, 5, 1}));
        System.out.println(isRotation(first, new int[] {3, 1, 5, 1, 2}));
        System.out.println(isRotation(first, new int[] {1, 5, 1, 2, 3}));
        System.out.println(isRotation(first, new int[] {5, 1, 2, 3, 1}));

        System.out.println();

        // fail case
        System.out.println(isRotation(first, new int[] {2, 1, 3, 1, 5}));
        System.out.println(isRotation(first, new int[] {5, 1, 3, 2, 1}));
        System.out.println(isRotation(first, new int[] {6, 1, 3, 2, 1}));
    }

    static boolean isRotation(int[] first, int[] second) {

        int firstRotationIndex = -1;

        for (int i = 0; i < first.length; i++) {
            if (second[0] == first[i]) {
                firstRotationIndex = i;
            }
        }

        // if cannot find same value
        if (firstRotationIndex == -1) {
            return false;
        }

        // if same first and second are array
        boolean isSame = true;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                isSame = false;
            }
        }

        if (isSame) {
            System.out.println("same");
            return true;
        }

        for (int i = 0; i < second.length; i++) {
            if (first[firstRotationIndex] != second[i]) {
                return false;
            }

            firstRotationIndex++;
            if (firstRotationIndex > first.length - 1) {
                firstRotationIndex = 0;
            }
        }

        return true;
    }
}
