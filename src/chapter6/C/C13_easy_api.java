package chapter6.C;

import java.io.*;
import java.math.BigInteger;

public class C13_easy_api {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(
                    new BigInteger(line.split(" ")[0]).add(
                            new BigInteger(line.split(" ")[1])
                    )
            );
        }
    }
}
