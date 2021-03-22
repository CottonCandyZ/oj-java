package chapter8.C;

import java.io.*;

public class C2_easy_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println();
        }
    }
    private static long hanoi(long n) {
        if (n == 1) {
            return 2;
        } else {
            // 移动顺序
            // N - 1 A -> C
            // 1 A -> B
            // N - 1 C -> A
            // 1 B -> C
            // N - 1 A -> C
            return 3 * hanoi(n - 1) + 2;
        }
    }

}
