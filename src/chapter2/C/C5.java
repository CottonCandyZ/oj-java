package chapter2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class C5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            answer(Integer.parseInt(s[0]), s[1].charAt(0), s[2].charAt(0));
        }
    }

    private static void answer(int n, char a, char b) {
        // 只需构建左上角一个小方块，其他部分都是对称的
        int len = n / 2 + 1;
        char fill; // 填充
        if (len % 2 == 0) {
            fill = b;
        } else {
            fill = a;
        }
        char[][] matrix = new char[len][len];
        for (int i = 0; i < len; i++) {
            matrix[0][i] = fill;
        }
        for (int i = 1; i < len; i++) {
            fill = matrix[i - 1][i] == a ? b : a;
            for (int j = 0; j < len; j++) {
                if (j < i) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = fill;
                }
            }
        }
        print(matrix);
    }

    private static void print(char[][] matrix) { // 上下对称
        int len = matrix[0].length;
        matrix[0][0] = ' ';
        for (int i = 0; i < len; i++) {
            printInside(matrix, len, i);
        }
        for (int i = len - 2; i >= 0 ; i--) {
            printInside(matrix, len, i);
        }
    }

    private static void printInside(char[][] matrix, int len, int i) { // 左右对称
        for (int j = 0; j < len; j++) {
            System.out.print(matrix[i][j]);
        }
        for (int j = len - 2; j >= 0; j--) {
            System.out.print(matrix[i][j]);
        }
        System.out.println();
    }

}








