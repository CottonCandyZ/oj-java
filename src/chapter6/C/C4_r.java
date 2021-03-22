package chapter6.C;

import java.io.*;
/* 也可
while ((line = br.readLine()) != null) {
            int input = Integer.parseInt(line.split(" ")[0]);
            int output = Integer.parseInt(line.split(" ")[1]);
            System.out.println(
                    new BigInteger(br.readLine(), input).toString(output)
            );
        }
 */
public class C4_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String number = br.readLine();
            System.out.println(conversion(Integer.parseInt(line.split(" ")[0]),
                    Integer.parseInt(line.split(" ")[1]),
                    number));
        }
    }
    private static String conversion(int input, int output, String string) {
        char[] dic = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z'
        };
        int len = string.length();
        char[] s = string.toCharArray();
        StringBuilder br = new StringBuilder();
        for (int i = 0; i < len;) {
            int carry = 0;
            for (int j = i; j < len; j++) {
                char tc = s[j];
                int temp;
                if (Character.isLetter(tc)) {
                    tc = Character.toLowerCase(tc);
                    temp = carry * input + tc - 'a' + 10;
                } else {
                    temp = carry * input + tc - '0';
                }
                carry = temp % output;
                s[j] = dic[(temp / output)];
            }
            br.append(dic[carry]);
            while (i < len && s[i] == '0') i++;
        }
        return br.reverse().toString();
    }
}
