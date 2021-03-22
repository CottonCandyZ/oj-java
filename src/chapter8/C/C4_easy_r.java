package chapter8.C;

import java.io.*;

public class C4_easy_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("0 0")) return;
            System.out.println(countNode(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1])));
        }
    }
    private static int countNode(int m, int n) {
        if (m > n) {
            return 0;
        } else {
            return 1 + countNode(m * 2, n) + countNode(m * 2 + 1, n);
        }
    }
}
