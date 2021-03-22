package chapter7.T;

import java.io.*;
import java.util.*;
// 好像使用 Hash 更慢了？
public class T1_middle_pass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> proxyServer = new HashMap<String, Integer>();
        String line;
        OUT:
        while ((line = br.readLine()) != null) {
            int proxySN = Integer.parseInt(line);
            for (int i = 0; i < proxySN; i++) {
                proxyServer.put(br.readLine(), i);
            }

            int accessN = Integer.parseInt(br.readLine());


            String[] access = new String[accessN];
            for (int i = 0; i < accessN; i++) {
                access[i] = br.readLine();
            }

            // 创建标记数组
            int[] tag = new int[accessN];
            int indexT = 0;

            for (int i = 0; i < accessN; i++) {
                String temp = access[i];
                Integer t;
                if ((t = proxyServer.get(temp)) != null) {
                    if (proxySN == 1) {
                        System.out.println("-1");
                        continue OUT;
                    }
                    tag[indexT++] = t;
                }
            }

            boolean[] b = new boolean[proxySN];
            int n = 0;
            int times = 0;
            for (int i = 0; i < indexT; i++) {
                if (!b[tag[i]]) {
                    b[tag[i]] = true;
                    n++;
                    if (n == proxySN) {
                        times++;
                        n = 0;
                        b = new boolean[proxySN];
                        // 回跳
                        i--;
                    }
                }
            }
            System.out.println(times);
        }
    }
}

/*
2
1
2
6
1
2
3
2
1
1
 */