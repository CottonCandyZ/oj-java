package chapter5.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
// 迭代器
public class C2_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            LinkedList<Integer> children = new LinkedList<Integer>();
            int len = Integer.parseInt(line.split(" ")[0]);
            for (int i = 1; i < len + 1; i++) {
                children.add(i);
            }
            Iterator<Integer> iterator = children.iterator();
            int start = Integer.parseInt(line.split(" ")[1]);
            int step = Integer.parseInt(line.split(" ")[2]);
            for (int i = 1; i < start; i++) {
                iterator.next();
            }

            while (len-- > 0) {
                int num = 0;
                for (int i = 0; i < step; i++) {
                    if (!iterator.hasNext()) {
                        iterator = children.iterator();
                    }
                    num = iterator.next();
                }
                sb.append(num).append(",");
                iterator.remove();
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
    }

}
