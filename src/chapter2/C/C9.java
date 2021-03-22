package chapter2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// https://www.nowcoder.com/practice/f5787c69f5cf41499ba4706bc93700a2?tpId=60&tqId=29497&tPage=2&ru=%2Fkaoyan%2Fretest%2F1001&qru=%2Fta%2Ftsing-kaoyan%2Fquestion-ranking&tab=answerKey
// 该题使用 Byte 翻转
public class C9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int L = Integer.parseInt(str.split(" ")[0]);
            int times = Integer.parseInt(str.split(" ")[1]);
            int start;
            int end;
            int len = L + 1;
            char[] pos = new char[len];
            for (int i = 0; i < len; i++) {
                pos[i] = 1;
            }
            int treeNum = 0;
            while (times-- > 0) {
                str = br.readLine();
                start = Integer.parseInt(str.split(" ")[0]);
                end = Integer.parseInt(str.split(" ")[1]);
                for (int i = start; i <= end; i++) {
                    pos[i] = 0;
                }
            }
            for (char po : pos) {
                if (po == 1)  {
                    treeNum++;
                }
            }
            System.out.println(treeNum);
        }
    }
}
