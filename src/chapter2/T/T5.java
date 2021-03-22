package chapter2.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 题目要求底部的长度在 3 ～ N 之间，且左右两侧的高度要比 底部长度 小的最大值
/*
n1, n3 分别为左右两侧的高度
n2 为底部的宽度
n1 = n3 = (N + 2) / 3
n2 = (N + 2) - (N + 2) / 3 * 2

 */
public class T5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            answer(str);
        }
    }
    private static void answer(String str) {
        int N = str.length();
        int height = (N + 2) / 3;
        int width = (N + 2) - height * 2;
//        System.out.println("length=" + N + ", height=" + height + ", width=" + width);
        for (int i = 0; i < height - 1; i++) {
            System.out.print(str.charAt(i));
            for (int j = 0; j < width - 2; j++) {
                System.out.print(" ");
            }
            System.out.println(str.charAt(str.length() - 1 - i));
        }
        // ⚠️ 使用substring
        System.out.println(str.substring(height - 1, height + width - 1));
    }

}
