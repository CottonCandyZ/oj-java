package chapter2.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.nowcoder.com/practice/130aa2d7d1f5436b920229dca253893b?tpId=94&tqId=31053&tPage=1&ru=%2Fkaoyan%2Fretest%2F1011&qru=%2Fta%2Fbit-kaoyan%2Fquestion-ranking&tab=answerKey
// 这里给出闰年的判断，题设未要求判断闰年
public class T8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        String str;
        while (times-- > 0) {
            str = br.readLine();
            String[] s = str.split(" ");
            answer(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }

    }

    private static void answer(int year, int month, int day) {
        int[] dayTab = {
                0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };
        // 2月，单独判断闰年
        if (month == 2 && day == 28) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                print(year, 2, 29);
                return;
            }
        }
        // 判断月末
        if (day == dayTab[month]) {
            if (month == 12) {
                print(year + 1, 1, 1);
                return;
            }
            print(year, month + 1, 1);
            return;
        }
        // 正常
        print(year, month, day + 1);

    }
    private static void print(int year, int month, int day) {
        System.out.printf("%04d-%02d-%02d\n", year, month, day);;
    }
}
