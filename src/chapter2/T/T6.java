package chapter2.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.nowcoder.com/practice/a3417270d1c0421587a60b93cdacbca0?tpId=40&tqId=21439&tPage=1&rp=1&ru=%2Fta%2Fkaoyan&qru=%2Fta%2Fkaoyan%2Fquestion-ranking&tab=answerKey
// 使用相对年份计算更加快速，牛课上的均存 1 开始计算时间戳，感觉性能没这样写好
// 另外对于同年同月的特殊处理一下，提高性能
// subString 是左闭右开区间

public class T6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String begin;
        String end;
        while ((begin = br.readLine()) != null) {
            end = br.readLine();
            answer(begin, end);
        }
    }
    private static void answer(String beginDate, String endDate) {

        // 如果年月相同直接减就行
        if (beginDate.substring(0, 6).equals(endDate.substring(0, 6))) {
            System.out.println(Integer.parseInt(endDate.substring(6, 8)) - Integer.parseInt(beginDate.substring(6, 8)) + 1);
            return;
        }
        int beginYear = Integer.parseInt(beginDate.substring(0, 4));
        int beginMonth = Integer.parseInt(beginDate.substring(4, 6));
        int beginDay = Integer.parseInt(beginDate.substring(6, 8));
        int endYear = Integer.parseInt(endDate.substring(0, 4));
        int endMonth = Integer.parseInt(endDate.substring(4, 6));
        int endDay = Integer.parseInt(endDate.substring(6, 8));
        System.out.println(getDays(endYear, endMonth, endDay, beginYear) - getDays(beginYear, beginMonth, beginDay, beginYear) + 1);

    }
    // 判定闰年
    private static int isLeap(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 1 : 0;
    }
    // 判定年幼多少天
    private static int daysOfYear(int year) {
        return isLeap(year) == 1 ? 366 : 365;
    }
    private static int getDays(int year, int month, int day, int startYear) {
        int[][] dayTap = {
                {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
        };
        int days = 0;
        for (int i = startYear; i < year; i++) {
            days += daysOfYear(i);
        }
        int row = isLeap(year);
        for (int i = 1; i < month; i++) {
            days += dayTap[row][i];
        }
        days += day;
        return days;
    }
}
