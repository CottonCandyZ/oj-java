package chapter8.C;

import java.io.*;

public class C1_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(factorial(Long.parseLong(line)));
        }
    }
    private static long factorial(long n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
}
