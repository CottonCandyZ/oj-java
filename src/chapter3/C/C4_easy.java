package chapter3.C;
// https://www.nowcoder.com/practice/069e2130430c41229ab25e47fa0949a6?tpId=40&tqId=21489&tPage=1&rp=1&ru=%2Fta%2Fkaoyan&qru=%2Fta%2Fkaoyan%2Fquestion-ranking&tab=answerKey
import java.io.*;
import java.util.HashMap;
// 可以使用线性查找，这里选择更省事的 Hash 表
public class C4_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        while (br.readLine() != null) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            str = br.readLine().split(" ");
            for (int i = 0; i < str.length; i++)
                map.put(str[i], i);
            Integer index = map.get(br.readLine());

            System.out.println(index == null ? -1 : index);
        }
    }
}
