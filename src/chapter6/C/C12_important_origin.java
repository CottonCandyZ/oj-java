package chapter6.C;

import java.io.*;

public class C12_important_origin {
    private static class Matrix {
        int[][] value;
        int row;
        int col;
        Matrix(int row, int col) {
            value = new int[row][col];
            this.row = row;
            this.col = col;
        }
        Matrix(int row, int col, int[][] m) {
            value = m.clone();
            this.row = row;
            this.col = col;
        }
        Matrix multiply(Matrix matrix) {
            Matrix result = new Matrix(this.row, matrix.col);
            for (int i = 0; i < result.row; i++) {
                for (int j = 0; j < result.col; j++) {
                    for (int k = 0; k < this.col; k++) {
                        result.value[i][j] += this.value[i][k] * matrix.value[k][j];
                    }
                }
            }
            return result;
        }
        // 矩阵快速幂
        Matrix fastExponentiation(int k) {
            Matrix result = new Matrix(row, col);
            // 构建一个副本
            Matrix temp = new Matrix(row, col, value);
            // 构建单位阵
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == j) {
                        result.value[i][j] = 1;
                    } else {
                        result.value[i][j] = 0;
                    }
                }
            }
            // 类似普通快速幂
            while (k != 0) {
                if (k % 2 == 1) {
                    result = result.multiply(temp);
                }
                k >>= 1;
                temp = temp.multiply(temp);
            }
            return result;
        }
        void print() {
            for (int i = 0; i < row; i++) {
                System.out.print(value[i][0]);
                for (int j = 1; j < col; j++) {
                    System.out.print(" " +value[i][j]);
                }
                System.out.println();
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.split(" ")[0]);
            int k = Integer.parseInt(line.split(" ")[1]);
            Matrix matrix = readMatrix(br, n, n);
            matrix = matrix.fastExponentiation(k);
            matrix.print();
        }
    }
    private static Matrix readMatrix(BufferedReader br, int row, int col) throws IOException {
        String[] line;
        Matrix matrix = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix.value[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }
}
