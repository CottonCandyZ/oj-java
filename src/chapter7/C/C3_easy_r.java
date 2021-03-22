package chapter7.C;

import java.io.*;
import java.util.*;

public class C3_easy_r {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        while (br.readLine() != null) {
            br.readLine();
            str = br.readLine().split(" ");
            int n = str.length;
            Long[] attack = new Long[n];
            for (int i = 0; i < n; i++) {
                attack[i] = Long.parseLong(str[i]);
            }
            str = br.readLine().split(" ");
            int m = str.length;
            Long[] defensive = new Long[m];
            for (int i = 0; i < m; i++) {
                defensive[i] = Long.parseLong(str[i]);
            }
            Arrays.sort(attack, Collections.reverseOrder());
            Arrays.sort(defensive);
            long bonus = 0;
            for (int i = 0; i < n; i++) {
//                有误
//                if (attack[i] > defensive[i]) {
//                    bonus += attack[i] - defensive[i];
//                } else {
//                    break;
//                }
                if (i >= m || defensive[i] >= attack[i]) {
                    break;
                }
                bonus += attack[i] - defensive[i];
            }
            System.out.println(bonus);
        }
    }
}
