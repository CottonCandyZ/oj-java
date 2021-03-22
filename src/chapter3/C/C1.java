package chapter3.C;

import java.io.*;
import java.util.*;
// https://www.nowcoder.com/practice/508f66c6c93d4191ab25151066cb50ef?tpId=40&tqId=21542&tPage=1&rp=1&ru=%2Fta%2Fkaoyan&qru=%2Fta%2Fkaoyan%2Fquestion-ranking&tab=answerKey
// 对于需要降序的情况使用：
// Arrays.sort(numbers, Collections.reverseOrder());
public class C1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] str;
        while ((line = br.readLine()) != null) {
            int times = Integer.parseInt(line);
            str = br.readLine().split(" ");
            int[] numbers = new int[times];
            int i = 0;
            for (String s : str) {
                numbers[i++] = Integer.parseInt(s);
            }
            Arrays.sort(numbers);
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
