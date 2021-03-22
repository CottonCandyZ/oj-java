package chapter2.C;

import java.io.*;
// https://www.nowcoder.com/practice/20082c12f1ec43b29cd27c805cd476cd?tpId=60&tqId=29478&tPage=1&ru=%2Fkaoyan%2Fretest%2F1001&qru=%2Fta%2Ftsing-kaoyan%2Fquestion-ranking&tab=answerKey
// 最关键的在于记录每个字母的信息
// 可以使用一个数组，但两个数组性能更优
public class C10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            answer(str.toCharArray());
        }
    }
    private static void answer(char[] input) {
        // 第一行是在哪个按键上
        // 第二行是在按键上的第几个
        int[][] c_info = {
                {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8},
                {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4}
        };
        int len = input.length;
        int times = 0;
        times += c_info[1][input[0] - 'a'];
        for (int i = 1; i < len; i++) {
            int pos = input[i] - 'a';
            int bPos = input[i - 1] - 'a';
            if (c_info[0][bPos] == c_info[0][pos]) {
                times += 2;
            }

            // 其实只需要一个数组就够用了啊。用key顺序记录26个字母按键次数，
            // 然后判断两个字母是否在同一个按键上，如果在同一个按键上，那么下标差（字母间距）
            // 就等于按键次数差。
//            if (c_info[1][input[i] - 'a'] - c_info[1][input[i - 1] - 'a'] == input[i] - input[i - 1]) {
//                // 在同一个数组上
//            }
            times += c_info[1][pos];
        }
        System.out.println(times);
    }
}
