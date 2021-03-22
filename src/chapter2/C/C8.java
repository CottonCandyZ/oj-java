package chapter2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 本题的思路可以考虑先恢复成某一年的1月0日，然后分别计算累加的天数对应的年，对应的月和日
public class C8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        while (times-- > 0) {
            String[] s = br.readLine().split(" ");
            answer(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
            solution(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
        }

    }
    private static void answer(int year, int month, int day, int plus) {
        int[][] dayTab = {
                {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };
        int row = isLeap(year);
        if (plus <= dayTab[row][month] - day) {
            System.out.printf("%04d-%02d-%02d\n", year, month, day + plus);
            return;
        }
        plus -= dayTab[row][month] - day;
        month++;
        if (month == 13) {
            month = 1;
            year++;
            row = isLeap(year);
        }
        while (plus > dayTab[row][month]) {
            plus -= dayTab[row][month];
            month++;
            if (month == 13) {
                month = 1;
                year++;
                row = isLeap(year);
            }
        }
        day = plus;
        System.out.printf("%04d-%02d-%02d\n", year, month, day);

    }

    private static void solution(int year, int month, int day, int plus) {
        int[][] dayTab = {
                {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };
        int row = isLeap(year);
        // 这里很重要！！先加上前面的
        for (int i = 1; i < month; i++) {
            plus += dayTab[row][i];
        }
        plus += day;
        // 确定年
        while (plus > numbersOfYear(year)) {
            plus -= numbersOfYear(year);
            year++;
        }
        month = 1;
        row = isLeap(year);
        // 确定月
        while (plus > dayTab[row][month]) {
            plus -= dayTab[row][month];
            month++;
        }
        day = plus;
        System.out.printf("%04d-%02d-%02d\n", year, month, day);

    }

    private static int numbersOfYear(int year) {
        return isLeap(year) == 1 ? 366 : 365;
    }
    private static int isLeap(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 1 : 0;
    }
}
