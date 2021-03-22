package chapter6.T;

import java.io.*;
// 使用 long 可以显著提高速度
// Long.toString() 第二个参数可以设定输出的进制
public class T2_easy_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("0")) return;
            int tran = Integer.parseInt(line.split(" ")[0]);
            long num1 = Integer.parseInt(line.split(" ")[1]);
            long num2 = Integer.parseInt(line.split(" ")[2]);
            System.out.println(Long.toString(num1 + num2, tran));
        }
    }
}
