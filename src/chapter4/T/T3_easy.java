package chapter4.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 也可以直接判断空格，空格后的字母一律变成大写
public class T3_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            char[] s = line.toCharArray();
            if (Character.isLowerCase(s[0])) {
                s[0] = Character.toUpperCase(s[0]);
            }
            boolean flag = false;
            for (int i = 1; i < s.length; i++) {
                char c = s[i];
                if (c == ' ' || c == '\t' || c == '\r' || c == '\n') {
                    flag = true;
                    continue;
                }
                if (flag) {
                    flag = false;
                    if (Character.isLowerCase(c)) {
                        s[i] = Character.toUpperCase(c);
                    }
                }
            }
            System.out.println(s);
        }
    }
}
