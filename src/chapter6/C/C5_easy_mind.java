package chapter6.C;

import java.io.*;

public class C5_easy_mind {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int first = Integer.parseInt(line.split(" ")[0]);
            int second = Integer.parseInt(line.split(" ")[1]);
//            int result = Math.min(first, second);
//            while (result-- > 0) {
//                if (first % result == 0 && second % result == 0) {
//                    break;
//                }
//            }
//            System.out.println(result);
            // 记住下面的
            while (first != 0) {
                int temp = second % first;
                second = first;
                first = temp;
            }
            System.out.println(second);
        }
    }
}
