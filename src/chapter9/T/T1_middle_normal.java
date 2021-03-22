package chapter9.T;

import java.io.*;
import java.util.*;

public class T1_middle_normal {
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
        if (Judge(s.toCharArray())) return 0;
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

                if (Judge(next)) {
                    return current.times + 1;
                }

                // 压入新状态
                statuses.add(new Status(next, current.times + 1));
            }
        }
        return -1;
    }

    private static boolean Judge(char[] s) {
        for (int i = 0; i + 3 < s.length - 1; i++) {
            if (s[i] == '2' && s[i + 1] == '0' && s[i + 2] == '1' && s[i + 3] == '2') {
                return true;
            }
        }
        return false;
    }
}
