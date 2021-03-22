package chapter6.C;

import java.io.*;

public class C11_easy_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] m1 = readMatrix(2, 3, br);
        int[][] m2 = readMatrix(3, 2, br);
        int[][] result = new int[2][2];
        // 留意一下矩阵乘法的计算
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    private static int[][] readMatrix(int height, int width, BufferedReader reader) throws IOException {
        String[] line;
        int[][] matrix = new int[height][width];

        for (int i = 0; i < height; i++) {
            line = reader.readLine().split(" ");
            for (int j = 0; j < width; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }
}
