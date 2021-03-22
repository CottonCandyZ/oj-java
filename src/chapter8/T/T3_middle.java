package chapter8.T;

import java.io.*;

public class T3_middle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            get(Integer.parseInt(line), sb);
            System.out.println(sb);
        }

    }
    // 题目要求倒过来，所以这里使用 insert
    // 注释掉的 append 可以正序
    private static void get(int num, StringBuilder sb) {
        int index = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                if (index == 0 || index == 1 || index == 2) {
                    String temp = index == 1 ? "" : "(" + index + ")";
                    sb.insert(0, "2" + temp);
//                    sb.append("2").append(index == 1 ? "" : "(" + index + ")");
                } else {
                    sb.insert(0, ")");
//                    sb.append("2(");
                    get(index, sb);
                    sb.insert(0, "2(");
//                    sb.append(")");
                }
                if (num / 2 != 0) {
                    sb.insert(0, "+");
//                    sb.append("+");
                }
            }
            index++;
            num /= 2;
        }
    }
    // 也可以先存进去然后倒过来读
//    public static void function(int n, StringBuilder str) {
//
//        List<Integer> list = new ArrayList<Integer>();
//        int count = 0;
//        while (n > 0) {
//            if (n % 2 == 1) {
//                list.add(count);
//            }
//            count++;
//            n = n / 2;
//        }
//        for (int i = list.size() - 1; i >= 0; i--) {
//            str.append("2");
//            if (list.get(i) == 2) {
//                str.append("(2)");
//            } else if (list.get(i) == 1) {
//                str.append("");
//            } else if (list.get(i) == 0) {
//                str.append("(0)");
//            } else {
//                str.append("(");
//                function(list.get(i), str);
//                str.append(")");
//            }
//            if (i != 0) {
//                str.append("+");
//            }
//        }
//    }
}
