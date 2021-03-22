package chapter4.C;

import java.io.*;
// 注意 char 到 int 需要强制类型转换
public class C2_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            char[] s = new char[line.length()];
            for (int i = 0; i < line.length(); i++) {
                char temp = line.charAt(i);
                if ((temp >= 'a' && temp <= 'z' || (temp >= 'A' && temp <= 'Z'))) {
                    if (temp == 'z') {
                        s[i] = 'a';
                    } else if (temp == 'Z') {
                        s[i] = 'A';
                    } else {
                        s[i] = (char) (temp + 1);
                    }
                } else {
                    s[i] = temp;
                }
            }
            System.out.println(s);
        }
    }
}
