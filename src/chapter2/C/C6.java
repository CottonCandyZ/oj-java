package chapter2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 记一下闰年的规则
public class C6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            answer(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }
    }
    private static void answer(int year, int month, int day) {
        int[][] dayTab = {
            {0, 31, 28, 31, 30, 31, 30 ,31, 31, 30, 31, 30},
            {0, 31, 29, 31, 30, 31, 30 ,31, 31, 30, 31, 30}
        };
        int row = 0;
        if (((year % 4 == 0) && year % 100 != 0) || year % 400 == 0){
            row = 1;
        }
        int numOfDays = 0;
        for (int i = 0; i < month; i++) {
            numOfDays += dayTab[row][i];
        }
        numOfDays += day;
        System.out.println(numOfDays);
    }
}
