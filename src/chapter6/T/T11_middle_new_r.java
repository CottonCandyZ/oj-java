package chapter6.T;

import java.io.*;
// 注意由于数列连续访问两个值，所以递归的时候需要记录中间值
public class T11_middle_new_r {
    private static int a0;
    private static int a1;
    private static int p;
    private static int q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(" ");
            a0 = Integer.parseInt(temp[0]);
            a1 = Integer.parseInt(temp[1]);
            p = Integer.parseInt(temp[2]);
            q = Integer.parseInt(temp[3]);
            int k = Integer.parseInt(temp[4]);
            int[] dp = new int[1000];
            System.out.println(getNum(k, dp) % 10000);
            // 非递归
//            int[] sum = new int[1000];
//            sum[0] = a0;
//            sum[1] = a1;
//            for (int i = 2; i <= k; i++) {
//                sum[i] = (p * sum[i - 1] + q * sum[i - 2]) % 10000;
//            }
//            System.out.println(sum[k]);
        }
    }
    private static int getNum(int k, int[] dp) {
        if (k == 0)
            return a0;
        if (k == 1)
            return a1;
        if (dp[k] != 0)
            return dp[k];
        return dp[k] = p * getNum(k - 1, dp) % 10000 + q * getNum(k - 2, dp) % 10000;
    }
}
