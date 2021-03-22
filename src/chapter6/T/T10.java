package chapter6.T;

import java.io.*;

public class T10 {
    private static class Matrix {
        int[][] value;
        int row;
        int col;
        Matrix(int row, int col) {
            value = new int[row][col];
            this.row = row;
            this.col = col;
        }
        int Judge(Matrix matrix) {
            boolean[] rowIsNotZero = new boolean[row];
            boolean[] colIsNotZero = new boolean[col];
            int result = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (value[i][j] + matrix.value[i][j] != 0) {
                        rowIsNotZero[i] = true;
                        colIsNotZero[j] = true;
                    }
                }
            }
            for (boolean b : rowIsNotZero) {
                if (!b) result++;
            }
            for (boolean b : colIsNotZero) {
                if (!b) result++;
            }
            return result;
        }
    }
    private static Matrix readMatrix(BufferedReader br, int row, int col) throws IOException {
        Matrix matrix = new Matrix(row, col);
        String[] line;
        for (int i = 0; i < row; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix.value[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("0")) return;
            int row = Integer.parseInt(line.split(" ")[0]);
            int col = Integer.parseInt(line.split(" ")[1]);
            Matrix m1 = readMatrix(br, row, col);
            Matrix m2 = readMatrix(br, row, col);
            System.out.println(m1.Judge(m2));
        }
    }
}
