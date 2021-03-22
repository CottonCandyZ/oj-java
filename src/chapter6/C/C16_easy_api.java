package chapter6.C;

import java.io.*;
import java.math.BigInteger;

public class C16_easy_api {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("-1")) return;
            BigInteger c = new BigInteger(line);
            BigInteger zero = new BigInteger("0");
            boolean tag = false;
            for (long i = 2; i <= 9 ; i++) {
                if (c.mod(BigInteger.valueOf(i)).compareTo(zero) == 0) {
                    System.out.print(i + " ");
                    tag = true;
                }
            }
            if (!tag) System.out.print("none");
            System.out.println();
        }
    }
}
