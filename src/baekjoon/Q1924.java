package baekjoon;

import java.util.*;

public class Q1924 {

    public static void main(String[] args) {

        final String[] WEEK_DAY = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        final int[] LAST_DAY_OF_MONTH = {31, // Jan
                28, // Feb
                31, // Mar
                30, // Apr
                31, // May
                30, // June
                31, // July
                31, // Aug
                30, // Sep
                31, // Oct
                30, // Nov
                31 // Dec
        };

        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int day = in.nextInt();

        int result = 0;

        for(int i=0; i<month-1; i++){
            result += LAST_DAY_OF_MONTH[i];
        }
        result += day;
        System.out.println(WEEK_DAY[result % 7]);
    }
}
