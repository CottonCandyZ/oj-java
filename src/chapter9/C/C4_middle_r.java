package chapter9.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class C4_middle_r {
    private static int[] num;
    private static boolean[] visit;
    private static int n;
    private static int side;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] str;
        while ((line = br.readLine()) != null) {
            int times = Integer.parseInt(line);
            for (int i = 0; i < times; i++) {
                str = br.readLine().split(" ");
                n = Integer.parseInt(str[0]);
                num = new int[n];
                visit = new boolean[n];
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    num[j] = Integer.parseInt(str[j + 1]);
                    sum += num[j];
                }
                if (sum % 4 != 0) {
                    System.out.println("no");
                    continue;
                }
                // 边长
                side = sum / 4;
                // 库函数只支持从小到大
                Arrays.sort(num);
                // 这里将其 reverse 一下
                reverse(num);
                // 判断最大的那一根是否大于0
                if (num[0] > side) {
                    System.out.println("no");
                    continue;
                }
                if (DFS(0, 0, 0)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }


    }
    // 确认状态集
    // (sum, number, position)
    // sum 当前拼凑的木棍长度
    // number 已拼凑成边长的数量
    // position 为当前木棍的编号
    private static boolean DFS(int sum, int number, int position) {
        // 因为能够整除，计算前三组边就行
        if (number == 3) {
            return true;
        }
        int sample = 0;
        for (int i = position; i < n; i++) {
            // 如果被访问过了 // 拼起来比边长长 // 和为失败的棍子 就继续
            if (visit[i] || sum + num[i] > side || num[i] == sample) {
                continue;
            }
            visit[i] = true;
            // 凑成了一条边
            if (sum + num[i] == side) {
                if (DFS(0, number + 1, 0)) {
                    return true;
                } else {
                    // 记录失败的棍子长度
                    sample = num[i];
                }
            } else {
                // 凑不成一条边则继续凑
                if (DFS(sum + num[i], number, i + 1)) {
                    return true;
                } else {
                    // 记录失败的棍子长度
                    sample = num[i];
                }
            }
            // 还原
            visit[i] = false;
        }
        return false;
    }
    private static void reverse(int[] num) {
        int half = num.length / 2;
        int len = num.length;
        for (int i = 0; i < half; i++) {
            int temp = num[i];
            num[i] = num[len - i - 1];
            num[len - i - 1] = temp;
        }
    }
}
