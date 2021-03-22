package chapter6.T;

import java.io.*;
// 参考讨论
public class T9_middle_math_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            long num = Integer.parseInt(line.split(" ")[0]);
            long pow = Integer.parseInt(line.split(" ")[1]);
            long k = Integer.parseInt(line.split(" ")[2]);
            k--;
            long result = 1;
            while (pow != 0) {
                if (pow % 2 == 1) {
                    result *= num;
                    result %= k;
                }
                pow >>= 1;
                num *= num;
                num %= k;
            }
            // result == 0 的情况是其 num % (k-1) == 0 时此时结果为 k-1
            if (result == 0) result = k;
            System.out.println(result);
        }
    }
}
