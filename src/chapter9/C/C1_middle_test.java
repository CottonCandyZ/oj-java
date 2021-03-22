package chapter9.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1_middle_test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int start = Integer.parseInt(line.split(" ")[0]);
            int cow = Integer.parseInt(line.split(" ")[1]);
            int num = 0;
            // 这里除以 2 是猜的
            int half = start / 2;
            while (!(start - half < cow && cow < start + half)) {
                if (cow % 2 == 1) {
                    num++;
                }
                cow /= 2;
                num++;
            }
            num += Math.abs(start - cow);
            System.out.println(num);
        }
    }
}
