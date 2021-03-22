package chapter2.C;

// 小结：可以使用 Reverse 函数判断回文数

import java.util.ArrayList;

public class C3 {
    public static void main(String[] args) {
        for (int i = 1; i <= 256; i++) {
            int sq = i * i;
            ArrayList<Integer> numberList = new ArrayList<Integer>();
            do {
                numberList.add(sq % 10);
            } while((sq /= 10) != 0);
            if (palindrome(numberList)) {
                System.out.println(i);
            }
        }
    }
    static boolean palindrome(ArrayList<Integer> numberList) {
        for (int i = 0; i < numberList.size() / 2; i++) {
            if (!numberList.get(i).equals(numberList.get(numberList.size() - i - 1)))
                return false;
        }
        return true;
    }
}


class solution {
    public static void main(String[] args) {
        for (int i = 1; i <= 256; i++) {
            if (i * i == reverse(i * i)) {
                System.out.println(i);
            }
        }
    }
    static int reverse(int x) {
        int revX = 0;
        do {
            revX *= 10;
            revX += x % 10;
        } while ((x /= 10) != 0);
        return revX;
    }
}
