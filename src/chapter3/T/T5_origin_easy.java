package chapter3.T;
// 上机原题
import java.io.*;
// 有空格用 trim() 去掉
public class T5_origin_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int times = Integer.parseInt(line.trim());
            int i = 0;
            int[] x = new int[times];
            int[] y = new int[times];
            while (times-- > 0) {
                line = br.readLine();
                x[i] = Integer.parseInt(line.split(" ")[0]);
                y[i++] = Integer.parseInt(line.split(" ")[1]);
            }
            int xMin = x[0];
            int yMin = y[0];
            for (int j = 1; j < i; j++) {
                if (xMin > x[j]) {
                    xMin = x[j];
                    yMin = y[j];
                } else if (xMin == x[j]) {
                    if (yMin > y[j]) {
                        yMin = y[j];
                    }
                }
            }
            System.out.println(xMin + " " + yMin);
        }
    }
}
