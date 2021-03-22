package chapter6.T;

import java.io.*;
// 尽量避免使用 BigInteger
public class T3_easy_c {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(
                    Integer.parseInt(line.substring(2), 16)
            );
        }
    }
}
