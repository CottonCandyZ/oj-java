package chapter9.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T2_easy_dynamic_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int[] goods = new int[n];
            for (int i = 0; i < n; i++) {
                goods[i] = Integer.parseInt(br.readLine());
            }
            int[] method = new int[41];
            method[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 40; j >= goods[i]; j--) {
                    method[j] += method[j - goods[i]];
                }
            }
            System.out.println(method[40]);
        }
    }
}
