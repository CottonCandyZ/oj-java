package chapter6.C;

import java.io.*;
// 积的模等于模的积
public class C10_mind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("0 0")) return;
            int num = Integer.parseInt(line.split(" ")[0]);
            int pow = Integer.parseInt(line.split(" ")[1]);
            int result = 1;
            while (pow != 0){
                if (pow % 2 == 1) {
                    result *= num;
                    result %= 1000;
                }
                num *= num;
                num %= 1000;
                pow >>= 1;
            }
            System.out.println(result);
        }
    }
}
