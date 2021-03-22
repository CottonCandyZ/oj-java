package chapter2.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class T3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            int N = Integer.parseInt(str);
            str = reader.readLine();
            String[] s = str.split(" ");
            answer(N, Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }

    }

    static void answer(int N, int X, int Y, int Z) {
        for (int i = 9; i > 0; i--) {
            for (int j = 9; j >= 0; j--) {
                int sum = i * 10000 + X * 1000 + Y * 100 + Z * 10 + j;
                if (sum % N == 0) {
                    System.out.println(i + " " + j + " " + sum / N);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}
