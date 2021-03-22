package chapter4.C;

import java.io.*;

public class C5_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int[] times = new int[26];
            for (int i = 0; i < line.length(); i++) {
                char temp = line.charAt(i);
                if (temp >= 'A' && temp <= 'Z') {
                    times[temp - 'A']++;
                }
            }
            for (int i = 0; i < 26; i++) {
                System.out.println((char) (i + 'A') + ":" + times[i]);

            }

        }
    }
}
