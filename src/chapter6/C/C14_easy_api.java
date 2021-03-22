package chapter6.C;

import java.io.*;
import java.math.BigInteger;

public class C14_easy_api {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int i = Integer.parseInt(line);
            BigInteger fac = new BigInteger("1");
            while (i > 1) {
                fac = fac.multiply(new BigInteger(Integer.toString(i)));
                i--;
            }
            System.out.println(fac);
        }
    }
}
