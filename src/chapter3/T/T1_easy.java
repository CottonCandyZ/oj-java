package chapter3.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T1_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] str;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            str = br.readLine().split(" ");
            if (n == 1) {
                System.out.println(str[0]);
                System.out.println(-1);
                continue;
            }
            int[] num = new int[n];
            int i = 0;
            for (String s : str) {
                num[i++] = Integer.parseInt(s);
            }
            Arrays.sort(num);
            System.out.println(num[n - 1]);
            for (int j = 0; j < n - 1; j++) {
                System.out.print(num[j] + " ");
            }
            System.out.println();
        }
    }
}
