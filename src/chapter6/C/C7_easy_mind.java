package chapter6.C;
/// 记住素数判断

import java.io.*;

public class C7_easy_mind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(judge(Integer.parseInt(line)) ? "yes" : "no");
        }
    }
    private static boolean judge(int x) {
        if (x < 2) return false;
        int bound = (int) Math.sqrt(x);
        for (int i = 2; i <= bound; i++) {
            if (x % i == 0)  {
                return false;
            }
        }
        return true;
    }
}
