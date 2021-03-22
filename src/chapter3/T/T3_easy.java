package chapter3.T;

import java.io.*;
import java.util.Arrays;

public class T3_easy {
    private static class Mouse implements Comparable<Mouse> {
        int weight;
        String color;
        @Override
        public int compareTo(Mouse o) {
            return o.weight - weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int times = Integer.parseInt(line);
            Mouse[] mice = new Mouse[times];
            int i = 0;
            while (times-- > 0) {
                line = br.readLine();
                mice[i] = new Mouse();
                mice[i].weight = Integer.parseInt(line.split(" ")[0]);
                mice[i++].color = line.split(" ")[1];
            }
            Arrays.sort(mice);
            for (Mouse mouse : mice) {
                System.out.println(mouse.color + " ");
            }
        }
    }
}
