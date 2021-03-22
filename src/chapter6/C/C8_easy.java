package chapter6.C;

import java.io.*;
// 可以使用素数筛选法
// 见书 P.95
public class C8_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            int bound = Integer.parseInt(line);
            for (int i = 11; i < bound;) {
                if (judge(i)) sb.append(" ").append(i);
                i += 10;
            }
            if (sb.length() == 0) System.out.println("-1");
            else System.out.println(sb.substring(1));
        }
    }
    private static boolean judge(int num) {
        // 由于没有比 10 小的，直接算
        int bound = (int) Math.sqrt(num);
        for (int i = 2; i <= bound; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
