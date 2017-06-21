package baekjoon;

import java.util.*;

public class Q1110 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int x = num / 10;
        int y = num % 10;
        int temp =  y * 10 + ((x + y) % 10);;
        int iterationCnt = 1;

        while(num != temp) {
            x = temp / 10;
            y = temp % 10;
            temp = y * 10 + ((x + y) % 10);
            iterationCnt++;
        }

        System.out.println(iterationCnt);

        in.close(); /**/
    }
}
