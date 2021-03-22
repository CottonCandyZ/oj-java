package chapter7.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class C5_hard_r {
    private static class Island {
        long left;
        long right;
        public Island(long left, long right) {
            this.left = left;
            this.right = right;
        }
    }
    private static class Bridge implements Comparable<Bridge> {
        long length;
        long index;

        public Bridge(long length, long index) {
            this.length = length;
            this.index = index;
        }

        @Override
        public int compareTo(Bridge o) {
            if (length > o.length) {
                return 1;
            } else if (length < o.length) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    private static class Interval implements Comparable<Interval> {
        long max;
        long min;
        int index;

        public Interval(long max, long min, int index) {
            this.max = max;
            this.min = min;
            this.index = index;
        }

        @Override
        public int compareTo(Interval o) {
            if (min > o.min) {
                return 1;
            } else if (min < o.min) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int islandN = Integer.parseInt(line.split(" ")[0]);
            int bridgeN = Integer.parseInt(line.split(" ")[1]);
            Island[] islands = new Island[islandN];
            for (int i = 0; i < islandN; i++) {
                line = br.readLine();
                islands[i] = new Island(
                        Long.parseLong(line.split(" ")[0]),
                        Long.parseLong(line.split(" ")[1])
                );
            }
            String[] str = br.readLine().split(" ");
            Bridge[] bridges = new Bridge[bridgeN];
            for (int i = 0; i < bridgeN; i++) {
                bridges[i].index = i + 1;
                bridges[i].length = Integer.parseInt(str[i]);
            }
            Arrays.sort(bridges);
            Interval[] intervals = new Interval[islandN];
            for (int i = 0; i < islandN - 1; i++) {
                intervals[i] = new Interval(
                        islands[i + 1].right - islands[i].left,
                        islands[i + 1].left - islands[i].right, i
                );
            }
            Arrays.sort(intervals);

            // 以下为参考
            // 解决
            long[] answer = new long[bridgeN];
            Queue<Interval> queue = new LinkedList<Interval>();
            int position = 0; // 当前区间下标
            int number = 0; // 搭建桥的数目
            for (int i = 0; i < bridgeN; i++) {
                // 符合前一个桥长度要求的已经被压入队列，后面的桥只会比前面的桥长
                // 所以只需要将长度大于岛屿之间的最大值的桥去掉即可
                while (!queue.isEmpty() && queue.peek().max < bridges[i].length)
                    queue.poll();
                // 满足要求的直接压入队列
                while (position < islandN - 1 && intervals[position].min <= bridges[i].length &&
                        intervals[position].max >= bridges[i].length) {
                    queue.add(intervals[position]);
                }
                // 弹出第一个符合要求的
                if (!queue.isEmpty()) {
                    answer[queue.poll().index] = bridges[i].index;
                    number++;
                }
            }
            if (number == islandN - 1) {
                System.out.println("YES");
                for (int i = 0; i < number; i++) {
                    System.out.println(answer[i] + " ");
                }
            } else {
                System.out.println("NO");
            }

        }
    }
}
