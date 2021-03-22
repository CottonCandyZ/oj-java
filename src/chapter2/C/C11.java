package chapter2.C;

import java.io.*;
// https://www.nowcoder.com/practice/75c189249d6145cfa33cd53edae6afc8?tpId=63&tqId=29579&tPage=1&ru=%2Fkaoyan%2Fretest%2F9001&qru=%2Fta%2Fzju-kaoyan%2Fquestion-ranking&tab=answerKey
public class C11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            if (str.equals("0")) break;
            answer(Integer.parseInt(str));
        }
    }
    private static void answer(int num) {
        int i = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = (num * 3 + 1) / 2;
            }
            i++;
        }
        System.out.println(i);
    }
}
