package chapter8.T;

import java.io.*;

public class T1_easy_r {
    private static final int MAX = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int[][] cache = new int[MAX][MAX];
        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print(yangHui(i, j, cache) + " ");
                }
                System.out.println();
            }
        }


    }
    private static int yangHui(int i, int j, int[][] cache) {
        // 第一列 或 每一行 最后一列
        if (j == 0 || i == j) return cache[i][j] = 1;
        if (cache[i][j] != 0) return cache[i][j];
        // 将上一行的前一列和这一行对应额一列相加
        return cache[i][j] = yangHui(i - 1, j - 1, cache) + yangHui(i - 1, j, cache);
    }
}
