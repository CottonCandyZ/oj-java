package chapter5.C;
// 不要使用数组，直接构建字符串
public class C1_easy_c {
    public static void main(String[] args) {
        StringBuilder wNumbers = new StringBuilder();
        StringBuilder yNumbers = new StringBuilder();

        for (int i = 2; i <= 60; i++) {
            int sum = 1;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) wNumbers.append(" ").append(i);
            if (sum > i) yNumbers.append(" ").append(i);
        }
        System.out.println("E:" + wNumbers);

        System.out.println("G:" + yNumbers);
    }
}
