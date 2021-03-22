package chapter2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
4
      ****
    ******
  ********
**********
 */
// 注意输出这种整齐排列的图像使用双层循环逐层渲染
public class C4 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = rd.readLine()) != null) {
//            answer(Integer.parseInt(str));
            solution(Integer.parseInt(str));
        }
    }

    private static void answer(int h) {
        int space = (h - 1) * 2;
        while (space >= 0) {
            int i = space;
            int j = h;
            while (i-- > 0) {
                System.out.print(" ");
            }
            while (j-- > 0) {
                System.out.print("*");
            }
            System.out.println();
            space -= 2;
            h += 2;
        }
    }
    private static void solution(int h) {
        int row = h;
        int col = h + (h - 1) * 2; // 计算底部长度
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j < col - (h + 2 * i)) // 计算空格个数 h + 2 * i 为每一行 * 的个数
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
