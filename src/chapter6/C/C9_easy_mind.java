package chapter6.C;

import java.io.*;

public class C9_easy_mind {
//    书中的方案
//    // MAX = (int) Math.sqrt(Math.pow(10, 9));
//    private static final int MAX = 31622;
//    private static final ArrayList<Integer> prim = new ArrayList<Integer>();
//    public static void main(String[] args) throws IOException {
//        init();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = br.readLine()) != null) {
//            int num = Integer.parseInt(line);
//            int times = 0;
//            for (int factor : prim) {
//                if (factor > num) break;
//                while (num % factor == 0) {
//                    num /= factor;
//                    times++;
//                }
//            }
//            // 还存在一个
//            if (num > 1) times++;
//            System.out.println(times);
//        }
//    }
//    private static void init() {
//        boolean[] isNotPrime = new boolean[MAX];
//        // 这里为了减少 init 消耗的时间 使用 isNotPrime 而不是 isPrime
//        isNotPrime[0] = true;
//        isNotPrime[1] = true;
//        for (int i = 0; i < MAX; i++) {
//            // 跳过非质数
//            if (isNotPrime[i]) {
//                continue;
//            }
//            prim.add(i);
//            for (int j = i * i; j < MAX && j > 0; j += i) {
//                isNotPrime[j] = true;
//            }
//        }
//
//    }
    // 有所参考提交的代码
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            int count = 1;
            if (num < 2) return;
            for (int i = 2; i * i < num; i++) {
                while (num % i == 0) {
                    count++;
                    num /= i;
                }
            }
            System.out.println(count);
        }
    }
}
