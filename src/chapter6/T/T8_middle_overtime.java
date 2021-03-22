package chapter6.T;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class T8_middle_overtime {
    // 超时
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = br.readLine()) != null) {
//            int n = Integer.parseInt(line.split(" ")[0]);
//            int a = Integer.parseInt(line.split(" ")[1]);
//            int f = factorial(n);
//            int k = 0;
//            for (; !(f % Math.pow(a, k) == 0 && f % Math.pow(a, k + 1) != 0); k++);
//            System.out.println(k);
//        }
//    }
//    private static int factorial(int num) {
//        int n = 1;
//        while (num > 1) {
//            n *= num--;
//        }
//        return n;
//    }
    private static final int MAX = 1000;
    private static final ArrayList<Integer> prim = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.split(" ")[0]);
            int a = Integer.parseInt(line.split(" ")[1]);
            int min = Integer.MAX_VALUE;
            int[] nFac = new int[MAX];
            int[] aFac = new int[MAX];
            int[] aF = new int[MAX];
            facForFactorial(n, nFac);
            facForNormal(a, aFac, aF);
            // 取二者质因子幂娇小的一个
            for (int i : aF) {
                if (nFac[i] > 0) {
                    if (nFac[i] / aFac[i] < min) min = nFac[i] / aFac[i];
                }
            }
            System.out.println(min);
        }
    }
    // 这里计算阶乘的质因子
    private static void facForFactorial(int n, int[] result) {
        for (Integer factor : prim) {
            if (factor > n) break;
            int temp = n;
            while (temp != 0) {
                result[factor] += temp / factor;
                temp /= factor;
            }
        }
    }
    // 普通的质因子计算
    private static void facForNormal(int n, int[] result, int[] factor) {
        int i = 0;
        for (Integer f : prim) {
            if (f > n) break;
            while (n % f == 0) {
                n /= f;
                result[f]++;
                factor[i++] = f;
            }
        }
        if (n > 0) {
            result[n] = 1;
        }
    }
    // 素数筛
    private static void init() {
        boolean[] isNotPrim = new boolean[MAX];
        isNotPrim[0] = true;
        isNotPrim[1] = true;
        for (int i = 2; i < MAX; i++) {
            if (isNotPrim[i]) continue;
            prim.add(i);
            for (int j = i * i; j < MAX && j > 0; j += i) {
                isNotPrim[j] = true;
            }
        }
    }
}
