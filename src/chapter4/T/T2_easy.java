package chapter4.T;

import java.io.*;

public class T2_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] str;
        while ((line = br.readLine()) != null) {
            str = line.split(" ");
            String needToReplace = br.readLine();
            String replace = br.readLine();
            for (int i = 0; i < str.length; i++) {
                if (str[i].equals(needToReplace)) {
                    str[i] = replace;
                }
            }
            for (int i = 0; i < str.length - 1; i++) {
                System.out.print(str[i] + " ");
            }
            System.out.println(str[str.length - 1]);

        }
    }
}
