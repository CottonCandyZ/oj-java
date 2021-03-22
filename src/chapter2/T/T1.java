package chapter2.T;

import java.util.Scanner;
// 注意题目要求是小于 100，可以投机指判断前两位
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(answer(Integer.parseInt(scanner.nextLine())));
        }
    }
    static int answer(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 7 == 0 || i % 10 == 7 || i / 10 == 7) {
                continue;
            }
            sum += i * i;
        }
        return sum;
    }
}
