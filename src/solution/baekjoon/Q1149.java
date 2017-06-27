package solution.baekjoon;
/*
문제
RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 집 i의 이웃은 집 i-1과 집 i+1이다. 처음 집과 마지막 집은 이웃이 아니다.

각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 모든 집을 칠할 때 드는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다. 둘째 줄부터 N개의 줄에 각 집을 빨강으로 칠할 때, 초록으로 칠할 때, 파랑으로 칠할 때 드는 비용이 주어진다.

출력
첫째 줄에 모든 집을 칠할 때 드는 비용의 최솟값을 출력한다.

예제 입력  복사
3
26 40 83
49 60 57
13 89 99
예제 출력  복사
96
 */

import java.util.Scanner;

public class Q1149 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int houseCnt = sc.nextInt();

        if (houseCnt == 0) {
            System.out.println(0);
            return;
        }

        int[][] values = new int[houseCnt][3];
        for (int i = 0; i < values.length; i++) {
            values[i][0] = sc.nextInt();
            values[i][1] = sc.nextInt();
            values[i][2] = sc.nextInt();
        }

        int minIndex = fetchMinIndex(values[0])+fetchMiddleIndex(values[1]) <
            fetchMinIndex(values[1])+fetchMiddleIndex(values[1]) ? fetchMinIndex(values[0]) : fetchMiddleIndex(values[0]);

        int[] firstHouses = values[0];

        int totalValue = firstHouses[minIndex];
        for (int i = 1; i < values.length; i++) {
            int[] houses = values[i];
            if (minIndex == 0) {
                minIndex = houses[1] < houses[2] ? 1 : 2;
            } else if (minIndex == 1) {
                minIndex = houses[0] < houses[2] ? 0 : 2;
            } else if (minIndex == 2) {
                minIndex = houses[0] < houses[1] ? 0 : 1;
            }

            System.out.println("i=" + i + ", minIndex=" + minIndex);
            totalValue += houses[minIndex];
        }

        System.out.println(totalValue);
        sc.close();
    }

    static int fetchMinIndex(int[] arr) {
        return arr[0] <= arr[1] ? (arr[0] <= arr[2] ? 0 : 2) : (arr[1] < arr[2] ? 1 : 2);

    }

    static int fetchMiddleIndex(int[] arr) {
        return arr[0] <= arr[1] ? (arr[1] <= arr[2] ? 1 : 2) : (arr[0] < arr[2] ? 0 : 2);
    }

}
