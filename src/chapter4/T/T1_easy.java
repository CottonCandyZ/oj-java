package chapter4.T;

import java.io.*;

public class T1_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int weight = 1;
            int result = 0;
            for (int i = line.length() - 1; i >= 0; i--) {
                int num = Character.getNumericValue(line.charAt(i));
                weight <<= 1;
                if (num == 0) {
                    continue;
                }
                result += num * (weight - 1);
            }
            System.out.println(result);
        }
    }
}
