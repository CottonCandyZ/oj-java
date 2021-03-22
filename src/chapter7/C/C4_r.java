package chapter7.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C4_r {
    private static class Show implements Comparable<Show> {
        public Show(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        int startTime;
        int endTime;

        @Override
        public int compareTo(Show o) {
            return endTime - o.endTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            Show[] shows = new Show[n];
            for (int i = 0; i < n; i++) {
                line = br.readLine();
                shows[i] = new Show(
                        Integer.parseInt(line.split(" ")[0]),
                        Integer.parseInt(line.split(" ")[1])
                );
            }
            // 贪心策略
            // 按照结束时间排序
            Arrays.sort(shows);
            int count = 1;
            int endBefore = shows[0].endTime;
            for (int i = 1; i < n; i++) {
                if (endBefore <= shows[i].startTime) {
                    endBefore = shows[i].endTime;
                    count++;
                    System.out.println(shows[i].startTime + " " + shows[i].endTime);
                }
            }
            System.out.println(count);
        }

    }
}
