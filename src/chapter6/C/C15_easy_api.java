package chapter6.C;

import java.io.*;
import java.math.BigInteger;

public class C15_easy_api {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            String a = line.split("")[0];
            sb.append(a);
            int times = Integer.parseInt(line.split(" ")[1]);
            BigInteger result = new BigInteger("0");
            for (int i = 0; i < times; i++) {
                result = result.add(new BigInteger(sb.toString()));
                sb.append(a);
            }
            System.out.println(result);
        }
    }
}
