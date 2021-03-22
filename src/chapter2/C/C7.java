package chapter2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 预处理天数要写齐，上一题可以不写 12 月的
// 注意格式化打印 ⚠️
public class C7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            answer(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
    }

    private static void answer(int year, int numOfDays) {
        int[][] dayTab = {
                {0, 31, 28, 31, 30, 31, 30 ,31, 31, 30, 31, 30, 31},
                {0, 31, 29, 31, 30, 31, 30 ,31, 31, 30, 31, 30, 31}
        };
        int row = 0;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            row = 1;
        }
        int month;
        for (month = 0; numOfDays > dayTab[row][month]; month++) {
            numOfDays -= dayTab[row][month];
        }
        // 注意格式化输出
        System.out.printf("%04d-%02d-%02d\n", year, month, numOfDays);
    }
}
