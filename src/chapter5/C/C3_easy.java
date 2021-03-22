package chapter5.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
// LinkedList 奇妙用法
// 也可以为每个入队的动物标上序号，准备两个队列。
public class C3_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            LinkedList<String> list = new LinkedList<String>();
            int times = Integer.parseInt(line);
            while (times-- > 0) {
                line = br.readLine();
                if (line.split(" ")[0].equals("1")) {
                    list.add(line.split(" ")[1]);
                } else {
                    if (list.isEmpty()) continue;
                    String state = line.split(" ")[1];
                    if (state.equals("0")) {
                        System.out.print(list.pop() + " ");
                    } else if (state.equals("1")) {
                        Iterator<String> iterator = list.iterator();
                        while (iterator.hasNext()) {
                            String get;
                            if (Integer.parseInt(get = iterator.next()) > 0) {
                                iterator.remove();
                                System.out.print(get + " ");
                            }
                        }
                    } else {
                        Iterator<String> iterator = list.iterator();
                        while (iterator.hasNext()) {
                            String get;
                            if (Integer.parseInt(get = iterator.next()) < 0) {
                                iterator.remove();
                                System.out.print(get + " ");
                            }
                        }
                    }
                }
            }
        }
    }
}
/*
6
1 1
1 -1
2 0
1 2
2 -1
2 1
 */