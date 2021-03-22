package chapter8.T;

import java.io.*;
import java.util.Arrays;

public class T2_middle_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            char[] s = line.toCharArray();
            Arrays.sort(s);
            boolean[] tag = new boolean[s.length];
            char[] out = new char[s.length];
            get(s, 0, tag, out);
        }
    }
    // 可以将其想像成竖着排列的组
    // 例如
    // a a a
    // b b b
    // c c c
    // 第一组先取 a，标记数组标记为 true，代表已访问过
    // 然后递归调用
    // 第二组由于 a 标记为 true 跳过 取 b
    // 以此类推
    // 第三组结束后输出
    // 此时再依次将每一组用过的还原为 true
    // 访问到第几组由调用栈决定，每一组访问到第几个由 for 循环 i 决定，一次排列中是否访问过由 tag 数组决定
    private static void get(char[] s, int index, boolean[] tag, char[] out) {
        // 访问结束
        if (index == s.length) {
            System.out.println(out);
            return;
        }
        for (int i = 0; i < s.length; i++) {
            // 没有访问过
            if (!tag[i]) {
                out[index] = s[i];
                // 第一组内已访问过
                tag[i] = true;
                get(s, index + 1, tag, out);
                // 将访问过的还原
                tag[i] = false;
            }
        }
    }
}
