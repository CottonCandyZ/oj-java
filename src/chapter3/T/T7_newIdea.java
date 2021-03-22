package chapter3.T;

// https://www.nowcoder.com/practice/e3b2cc44aa9b4851bdca89dd79c53150?tpId=40&tqId=21560&tPage=1&rp=1&ru=%2Fta%2Fkaoyan&qru=%2Fta%2Fkaoyan%2Fquestion-ranking&tab=answerKey
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// Arrays.fill() 可以将数组填满一样的值
// 若不使用 HashSet
// 可以使用 * 号标记已经扫描过的位置，然后第二次遇到 * 号直接跳过

public class T7_newIdea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            char[] s = line.toCharArray();
            int count = 0;
            int[] index = new int[10];
            int indexI = 0;
            HashSet<Character> isBeenViewed = new HashSet<Character>();
            for (int i = 0; i < s.length - 1; i++) {
                if (isBeenViewed.contains(s[i])) continue;
                isBeenViewed.add(s[i]);
                count = 0;
                indexI = 0;
                index[indexI++] = i;
                for (int j = i + 1; j < s.length; j++)
                    if (s[i] == s[j]) {
                        count++;
                        index[indexI++] = j;
                    }
                indexI = 0;
                if (count >= 1) {
                    while (count-- > 0) {
                        System.out.print(s[i] + ":" + index[indexI++] + ",");
                    }
                    System.out.println(s[i] + ":" + index[indexI]);
                }
            }
        }
    }
}
