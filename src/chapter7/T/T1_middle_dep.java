package chapter7.T;

import java.io.*;
import java.util.*;

public class T1_middle_dep {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Boolean> proxyServer = new HashMap<String, Boolean>();
        String line;
        while ((line = br.readLine()) != null) {
            int proxySN = Integer.parseInt(line);
            for (int i = 0; i < proxySN; i++) {
                proxyServer.put(br.readLine(), false);
            }
            int accessN = Integer.parseInt(br.readLine());
            String[] access = new String[accessN];
            for (int i = 0; i < accessN; i++) {
                access[i] = br.readLine();
            }
            int n = 0;
            int times = 0;
            for (int i = 0; i < accessN; i++) {
                String tempAccess = access[i];
//                System.out.print(tempAccess);
                if (proxyServer.containsKey(tempAccess)) {
                    if (!proxyServer.get(tempAccess)) {
                        proxyServer.put(tempAccess, true);
                        n++;
                        // 找到最远的一个第一次出现的代理 IP
                        if (n == proxySN) {
                            times++;
                            n = 0;
                            for (Map.Entry<String, Boolean> stringBooleanEntry : proxyServer.entrySet()) {
                                stringBooleanEntry.setValue(false);
                            }
                            // 注意这里已经发生 ip 冲突，所以要回到上一个
                            i--;
//                            System.out.print(" 替换");
                        }
                    }
                }
            }
            System.out.println(times);
        }
    }
}
/*
3
166.111.4.100
162.105.131.113
202.112.128.69
12
72.14.235.104
166.111.4.100
207.46.19.190
202.112.128.69
162.105.131.113
118.214.226.52
72.14.235.104
166.111.4.100
207.46.19.190
202.112.128.69
162.105.131.113
118.214.226.52
 */

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