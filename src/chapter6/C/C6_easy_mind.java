package chapter6.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 两个数的最小公倍数 = a * b / 最大公因数
public class C6_easy_mind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int first = Integer.parseInt(line.split(" ")[0]);
            int second = Integer.parseInt(line.split(" ")[1]);
            System.out.println(first * second / GCD(first, second));
        }
    }
    private static int GCD(int first, int second) {
        while (first != 0) {
            // 注意一二两行相对顺序一致
            int temp =  second % first;
            second = first;
            first = temp;
        }
        return second;
    }
}
