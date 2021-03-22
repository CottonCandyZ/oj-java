package chapter3.C;
// 上机原题

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
// 注意 Arrays.asList 配合 HashSet 使用
// 另外，如需要二分查找，可以使用 Arrays.binarySearch()
public class C5_origin_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        while (br.readLine() != null) {
            str = br.readLine().split(" ");
            int len;
            HashSet<String> map = new HashSet<String>(Arrays.asList(str));
            br.readLine();
            str = br.readLine().split(" ");
            len = str.length;
            for (int i = 0; i < len; i++) {
                System.out.println(map.contains(str[i]) ? "YES" : "NO");
            }

        }
    }

}
