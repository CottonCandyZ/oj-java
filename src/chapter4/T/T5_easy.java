package chapter4.T;

import java.io.*;
import java.util.Arrays;

public class T5_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] s = new String[line.length()];
            for (int i = 0; i < s.length; i++) {
                s[i] = line.substring(i, s.length);
            }
            Arrays.sort(s);
            for (String s1 : s) {
                System.out.println(s1);
            }
        }
    }
}
