package chapter2.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://www.nowcoder.com/practice/a3417270d1c0421587a60b93cdacbca0?tpId=40&tqId=21439&tPage=1&rp=1&ru=%2Fta%2Fkaoyan&qru=%2Fta%2Fkaoyan%2Fquestion-ranking&tab=answerKey
public class T7 {
    public static void main(String[] args) throws IOException {
        String[] month = {
                "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
        };
        HashMap<String, Integer> monthMap = new HashMap<String, Integer>();
        for (int i = 0; i < 12; i++) {
            monthMap.put(month[i], i);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            answer(Integer.parseInt(s[0]), monthMap.get(s[1]) + 1, Integer.parseInt(s[2]));
        }
    }
    private static void answer(int day, int month, int year) {
        String[] week = {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };
        int[][] dayTab = {
                {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };
        int days = 4;
        for (int i = 2000; i < year; i++) {
            days += daysOfYear(i);
        }
        int row = isLeap(year);
        for (int i = 1; i < month; i++) {
            days += dayTab[row][i];
        }
        days += day;
        System.out.println(week[days % 7]);
    }

    private static int isLeap(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 1 : 0;
    }

    private static int daysOfYear(int year) {
        return isLeap(year) == 1 ? 366 : 365;
    }
}
