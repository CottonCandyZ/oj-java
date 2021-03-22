package chapter7.C;

import java.io.*;

public class C1_easy_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int foot = Integer.parseInt(line);
            int atLeast = 0;
            int atMost = 0;
            if (foot % 2 == 0) {
                atLeast = foot / 4 + (foot % 4) / 2;
                atMost = foot / 2;
            }
            System.out.println(atLeast + " " + atMost);
        }
    }
}
