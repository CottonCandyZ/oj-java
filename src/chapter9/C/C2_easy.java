package chapter9.C;

import java.io.*;
import java.util.*;
// 这个题目的测试用例结果似乎有问题
public class C2_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("0")) return;
            System.out.println(BFS(Long.parseLong(line)));
        }
        // 测试所有 case
//        for (long i = 1; i < 201; i++) {
//            System.out.println(i + " " + BFS(i));
//        }

    }
    private static long BFS(long n) {
        Queue<Long> statuses = new LinkedList<Long>();
        statuses.add(1L);
        while (!statuses.isEmpty()) {
            // 取第一个
            long current = statuses.poll();
            if (current % n == 0) {
                return current;
            }
            // 两种状态
            // 先优先乘个 10
            current *= 10;
            statuses.add(current);
            statuses.add(current + 1);
//            for (int i = 0; i < 2; i++) {
//
//                if (i == 1) {
//                    current += 1;
//                }
//                statuses.add(current);
//            }
        }
        return -1;
    }

}
