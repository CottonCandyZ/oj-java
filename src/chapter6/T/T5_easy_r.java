package chapter6.T;

import java.io.*;
import java.util.Arrays;

public class T5_easy_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("0")) return;
            String[] str = br.readLine().split(" ");
            int[] nums = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                nums[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(nums);
            int times = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int numerator = nums[i];
                    int denominator = nums[j];
                    if (numerator < denominator && GCD(numerator, denominator) == 1)
                        times++;
                }
            }
            System.out.println(times);
        }
    }
    private static int GCD(int first, int second) {
        while (first != 0) {
            int temp = second % first;
            second = first;
            first = temp;
        }
        return second;
    }
}
