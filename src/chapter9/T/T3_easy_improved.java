package chapter9.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T3_easy_improved {
    // 只需计算一半
    private static final String[] result = new String[46];
    // 作为记录 result 的 index 使用
    private static int resultNum = 0;
    // 列方向
    private static final boolean[] col = new boolean[8];
    // \ 方向
    private static final boolean[] right = new boolean[15];
    // / 方向
    private static final boolean[] left = new boolean[15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        DFS(0, "");
        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line) - 1;
            if (num < 46) {
                System.out.println(result[num]);
            } else {
                int index = 91 - num;
                char[] s = result[index].toCharArray();
                for (int i = 0; i < 8; i++) {
                    System.out.print(9 - Character.getNumericValue(s[i]));
                }
                System.out.println();
            }
        }

    }
    // 确认状态
    // (line, s)
    // line 行数
    // s 存
    private static void DFS(int line, String s) {
        if (resultNum == 46) {
            return;
        }
        if (line == 8) {
            result[resultNum++] = s;
            return;
        }
        for (int i = 0; i < 8; i++) {
            // 判断列 和 两个方向斜对角
            // 斜对角规律
            // \ 方向是差值一样
            // / 方向是和一样
            if (col[i] || right[7 + line - i] || left[line + i]) {
                continue;
            }

            col[i] = true;
            right[7 + line - i] = true;
            left[line + i] = true;

            DFS(line + 1, s + (i + 1));
            col[i] = false;
            right[7 + line - i] = false;
            left[line + i] = false;
        }
    }
}
/*
斜对角规律
(0, 0)  (0, 1)  (0, 2)  (0, 3)  (0, 4)  (0, 5)  (0, 6)  (0, 7)
(1, 0)  (1, 1)  (1, 2)  (1, 3)  (1, 4)  (1, 5)  (1, 6)  (1, 7)
(2, 0)  (2, 1)  (2, 2)  (2, 3)  (2, 4)  (2, 5)  (2, 6)  (2, 7)
(3, 0)  (3, 1)  (3, 2)  (3, 3)  (3, 4)  (3, 5)  (3, 6)  (3, 7)
(4, 0)  (4, 1)  (4, 2)  (4, 3)  (4, 4)  (4, 5)  (4, 6)  (4, 7)
(5, 0)  (5, 1)  (5, 2)  (5, 3)  (5, 4)  (5, 5)  (5, 6)  (5, 7)
(6, 0)  (6, 1)  (6, 2)  (6, 3)  (6, 4)  (6, 5)  (6, 6)  (6, 7)
(7, 0)  (7, 1)  (7, 2)  (7, 3)  (7, 4)  (7, 5)  (7, 6)  (7, 7)
 */
