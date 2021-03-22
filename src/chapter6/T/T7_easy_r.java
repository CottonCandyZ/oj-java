package chapter6.T;

import java.io.*;

public class T7_easy_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        while (br.readLine() != null) {
            line = br.readLine().split(" ");
            int[] nums = new int[line.length];
            int i = 0;
            for (String s : line) {
                nums[i++] = Integer.parseInt(s);
            }
            for (int num : nums) {
                if (num == 1) {
                    System.out.println(1);
                    continue;
                }
                int count = 2;
                int j;
                for (j = 2; j * j < num; j++) {
                    if (num % j == 0) {
                        count += 2;
                    }
                }
                if (j * j == num) count++;
                System.out.println(count);
            }
        }
    }
    // 参考
    private static int solution(int num) {
        int result = 1;
        if (num == 1) {
            return 1;
        }
        for (int i = 2; i * i <= num; i++) {
            int k = 0;
            while (num % i == 0) {
                // 注意这里直接除了
                num /= i;
                k++;
            }
            if (k != 0) {
                result *= (k + 1);
            }
        }

        if (num != 1) result *= 2;
        if (result == 1) return 2;
        return result;
    }
}
