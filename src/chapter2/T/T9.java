package chapter2.T;
import java.io.*;
// https://www.nowcoder.com/practice/23e3244406724ffa8330760f640c8149?tpId=63&tqId=29567&tPage=1&ru=%2Fkaoyan%2Fretest%2F9001&qru=%2Fta%2Fzju-kaoyan%2Fquestion-ranking&tab=answerKey
// 可以使用更加简化的判断语句
public class T9 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] s;
        while ((str = br.readLine()) != null) {
            s = str.split(" ");
            answer(
                    Integer.parseInt(s[0]),
                    Integer.parseInt(s[1]),
                    Integer.parseInt(s[2]),
                    Integer.parseInt(s[3]),
                    Integer.parseInt(s[4]),
                    Integer.parseInt(s[5])
            );
        }
    }
    private static void answer(int P, int T, int G1, int G2, int G3, int GJ) {
        // 1
        if (Math.abs(G1 - G2) <= T) {
            print((double) (G1 + G2) / 2);
            return;
        }
        if (Math.abs(G1 - G3) <= T) {
            if (Math.abs(G2 - G3) <= T) {
                print(Math.max(Math.max(G1, G2), G3));
                return;
            }
            print((double) (G1 + G3) / 2);
            return;
        } else if (Math.abs(G2 - G3) <= T) {
            print((double) (G1 + G3) / 2);
            return;
        }
        print(GJ);
    }
    private static void print(double grade) {
        System.out.printf("%.1f", grade);
    }
}
