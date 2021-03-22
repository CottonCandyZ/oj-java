package chapter2.T;
// https://www.nowcoder.com/practice/64b472c9bed247b586859978d13145ad?tpId=62&tqId=29457&tPage=1&ru=%2Fkaoyan%2Fretest%2F2002&qru=%2Fta%2Fsju-kaoyan%2Fquestion-ranking&tab=answerKey
import java.io.*;
import java.util.*;
public class T10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String [] temp;
        String[][] s;
        while ((str = br.readLine()) != null) {
            if (str.equals("0")) break;
            int times = Integer.parseInt(str);
            temp = new String[times];
            s = new String[times][];
            int i = 0;
            while (times-- > 0) {
                temp[i++] = br.readLine();
            }
            Arrays.sort(temp);
            for (int j = 0; j < i; j++) {
                s[j] = temp[j].split("\\\\");
            }
            answer(s);
        }
    }
    private static void answer(String[][] s) {
        for (int i = 0; i < s[0].length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            System.out.println(s[0][i]);
        }
        boolean flag;

        for (int i = 1; i < s.length; i++) {
            int j = 0;
            // 跳过相同的
            while (j < s[i].length && s[i][j].equals(s[i - 1][j])) j++;
            for (; j < s[i].length; j++) {
                for (int k = 0; k < j; k++) {
                    System.out.print("  ");
                }
                System.out.println(s[i][j]);
            }
        }
        System.out.println();
    }
}
