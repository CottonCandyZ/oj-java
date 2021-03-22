package chapter4.C;

import java.io.*;
import java.util.HashMap;
// 也可以用空间换时间，用标记数组，直接在对应的坐标上 ++，最后读的时候只输出第一行字符对应的坐标
public class C4_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("#")) break;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            char[] find = new char[line.length()];
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                map.put(c, 0);
                find[i] = c;
            }
            line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (map.containsKey(c)) {
                    int times = map.get(c);
                    map.put(c, ++times);
                }
            }

            for (char c : find) {
                System.out.println(c + " " + map.get(c));
            }
        }
    }
}
