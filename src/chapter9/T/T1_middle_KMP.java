package chapter9.T;


import java.io.*;
import java.util.*;
// 好像没直接匹配快
public class T1_middle_KMP {
    private static final int[] next = {-1, 0, 0, 0, 1};
    private static final char[] pattern = {'2','0','1','2'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (br.readLine() != null) {
            System.out.println(BFS(br.readLine()));
        }

    }
    private static class Status {
        public Status(char[] value, int times) {
            this.value = value;
            this.times = times;
        }

        char[] value;
        int times;
    }


    private static int BFS(String s) {
        // 不符合要求直接 return
        if (s.length() < 4) return -1;
        if (indexKMP(s.toCharArray())) return 0;
        Queue<Status> statuses = new LinkedList<Status>();
        // 将第一个先压入
        statuses.add(new Status(s.toCharArray(), 0));
        while (!statuses.isEmpty()) {
            Status current = statuses.poll();
            // 有 length - 1 种状态
            for (int i = 0; i < current.value.length - 1; i++) {
                // 复制一份
                char[] next = current.value.clone();

                // 似乎不需要判断无限的情况
//                if (current.times + 1 == current.value.length) {
//                    return -1;
//                }
                // 调换位置
                char temp = next[i];
                // 如果移位后没有发生变化，则继续
                if (temp == next[i + 1]) continue;
                next[i] = next[i + 1];
                next[i + 1] = temp;
                // 使用正则会非常慢
//                if (new String(next).matches("(.*)2012(.*)")) {
//                    return current.times + 1;
//                }

                if (indexKMP(next)) {
                    return current.times + 1;
                }

                // 压入新状态
                statuses.add(new Status(next, current.times + 1));
            }
        }
        return -1;
    }

    // KMP check
    private static boolean indexKMP(char[] s) {
        int i = 0, j = 0;
        while (i < s.length && j < pattern.length) {
            if (j == -1 || s[i] == pattern[j]) {
                i++; j++;
            } else {
                j = next[j];
            }
        }
        return j == pattern.length;
    }
}
