package chapter6.T;

import java.io.*;

public class T6_easy_rMind {
    static int[] prime = new int[10000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        init();
        while ((line = br.readLine()) != null) {
            System.out.println(prime[Integer.parseInt(line) - 1]);
        }
    }
    private static void init() {
        boolean[] isNotPrime = new boolean[104730];
        // 这里为了避免 init 消耗的时间 使用 isNotPrime 而不是 isPrime
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2, j = 0; j < 10000; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            prime[j++] = i;
            for (int k = i * i; k < 104730 && k > 0; k += i) {
                isNotPrime[k] = true;
            }
        }
    }
}
