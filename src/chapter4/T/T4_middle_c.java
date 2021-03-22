package chapter4.T;

import java.io.*;
/*
while ((s=reader.readLine())!=null) {
           BigDecimal a = new BigDecimal(s);
           BigDecimal b = new BigDecimal(reader.readLine());
           System.out.println(a.add(b).toString());
}
 */
public class T4_middle_c {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] first = line.split("\\.");
            String[] second = br.readLine().split("\\.");
            int firstDLen = first[1].length();
            int secondDLen = second[1].length();
            // 分清长短
            int[] lD  = firstDLen > secondDLen ? copy(first[1]) : copy(second[1]) ;
            int[] sD = firstDLen > secondDLen ? copy(second[1]) : copy(first[1]);
            int carry = 0;
            for (int i = sD.length - 1; i >= 0 ; i--) {
                int result = lD[i] + sD[i] + carry;
                lD[i] = result % 10;
                carry = result / 10;
            }
            // 去掉尾部的 0
            for (int i = lD.length - 1; i >= 0; i--) {
                if (lD[i] != 0) break;
                lD[i] = -1;
            }
            int firstILen = first[0].length();
            int secondILen = second[0].length();
            int[] lI = firstILen > secondILen ? copy(first[0]) : copy(second[0]);
            int[] sI = firstILen > secondILen ? copy(second[0]) : copy(first[0]);
            int j = lI.length - 1;


            for (int i = sI.length - 1; i >= 0; i--, j--) {
                int result = lI[j] + sI[i] + carry;
                lI[j] = result % 10;
                carry = result / 10;
            }
            // 计算高位进位
            while (carry != 0 && j >= 0) {
                int result = lI[j] + carry;
                lI[j] = result % 10;
                carry = result / 10;
            }
            // 进位溢出
            if (carry != 0) {
                System.out.print(carry);
            }
            for (int i : lI) {
                System.out.print(i);
            }
            System.out.print(".");
            for (int i : lD) {
                if (i != -1) {
                    System.out.print(i);
                }
            }
            System.out.println();


        }
    }
    public static int[] copy(String s) {
        int len = s.length();
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = Character.getNumericValue(s.charAt(i));
        }
        return num;
    }
}