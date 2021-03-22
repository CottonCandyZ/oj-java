package chapter4.C;

import java.io.*;
// 也可以用 'A'+ (c - 'A' - 5 + 26) % 26
public class C3_easy {
    public static void main(String[] args) throws IOException {
        char[] translate = {
                'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'
        };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("ENDOFINPUT")) break;
            line = br.readLine();
            char[] result = new char[line.length()];
            for (int i = 0; i < line.length(); i++) {
                char temp = line.charAt(i);
                if (temp >= 'A' && temp <= 'Z') {
                    result[i] = translate[temp - 'A'];
                } else {
                    result[i] = temp;
                }
            }
            br.readLine();
            System.out.println(result);

        }
    }
}
