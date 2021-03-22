package chapter6.C;
// 可以直接 System.out.println(Integer.toBinaryString(Integer.parseInt(line)));
// 二进制转 Integer.parseInt("1001", 2);
import java.io.*;
public class C1_origin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(line);
            while (num != 0) {
                sb.append(num % 2);
                num /= 2;
            }
            System.out.println(sb.reverse().toString());
        }
    }
}
