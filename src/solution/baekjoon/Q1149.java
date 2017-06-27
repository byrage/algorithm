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
4
26 40 83
49 60 57
13 89 99
1 10000 10000
예제 출력  복사
96
 */

import java.util.*;

public class Q1149 {

    public static void main(String[] args) {

        final int R = 0;
        final int G = 1;
        final int B = 2;

        Scanner sc = new Scanner(System.in);
        int houseCnt = sc.nextInt();

        int[][] colors = new int[houseCnt][3];
        int[][] dp = new int[houseCnt][3];

        for (int i = 0; i < colors.length; i++) {
            colors[i][R] = sc.nextInt();
            colors[i][G] = sc.nextInt();
            colors[i][B] = sc.nextInt();
        }

        dp[0][R] = colors[0][R];
        dp[0][G] = colors[0][G];
        dp[0][B] = colors[0][B];

        for (int i = 1; i < houseCnt; i++) {
            dp[i][R] = colors[i][R] + Math.min(dp[i - 1][G], dp[i - 1][B]);
            dp[i][G] = colors[i][G] + Math.min(dp[i - 1][R], dp[i - 1][B]);
            dp[i][B] = colors[i][B] + Math.min(dp[i - 1][R], dp[i - 1][G]);
        }

        int last = dp.length - 1;
        int result = Math.min(Math.min(dp[last][R], dp[last][G]), dp[last][B]);
        System.out.println(result);
    }
}
