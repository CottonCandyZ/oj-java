package chapter3.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T6_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        while (br.readLine() != null) {
            str = br.readLine().split(" ");
            int len = str.length;
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = Integer.parseInt(str[i]);
            }
            if (nums[0] != nums[1]) System.out.print(0 + " ");
            for (int j = 1; j < len - 1; j++) {
                if (nums[j] > nums[j - 1] && nums[j] > nums[j + 1] ||
                        nums[j] < nums[j - 1] && nums[j] < nums[j + 1]) {
                    System.out.print(j + " ");
                }
            }
            if (nums[len - 1] != nums[len - 2]) System.out.print(len - 1 + " ");
            System.out.println();
        }
    }
}
