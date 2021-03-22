package chapter2.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 记住输入留的格式
public class T2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            answer(Integer.parseInt(str));
        }
    }
    // 暴力求解
    static void answer(int money) {
        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100 - x; y++) {
                int z = 100 - x - y; // 不需要三层循环
//                if ((z * (double)1/3 + y * 3 + x * 5) <= money && (x + y + z == 100)) {
//                    System.out.println("x=" + x + ", y=" + y + ", z=" + z);
//                }
                if (x * 5 * 3 + y * 3 * 3 + z * 1 <= money * 3) { // 更佳合理的判断
                    System.out.println("x=" + x + ",y=" + y + ",z=" + z);
                }
            }
        }
    }
}
