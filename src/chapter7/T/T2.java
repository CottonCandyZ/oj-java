package chapter7.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T2 {
    static Station[] stations;
    private static class Station implements Comparable<Station> {
        double price;
        int distance;

        public Station(double price, int distance) {
            this.price = price;
            this.distance = distance;
        }

        @Override
        public int compareTo(Station o) {
            return distance - o.distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(" ");
            // 油箱容量
            int cMax = Integer.parseInt(str[0]);
            // 需要跑的距离
            int d = Integer.parseInt(str[1]);
            // 单位油跑多少公里
            int dAvg = Integer.parseInt(str[2]);
            // 加油站数量
            int n = Integer.parseInt(str[3]);
            stations = new Station[n];
            for (int i = 0; i < n; i++) {
                str = br.readLine().split(" ");
                stations[i] = new Station(Double.parseDouble(str[0]), Integer.parseInt(str[1]));
            }
            Arrays.sort(stations);
            for (Station station : stations) {
                System.out.println(station.price + " " + station.distance);
            }












            // 如果在加满油的区间内存在比当前加油价格更低的则
            // 加到能够跑到低价加油站位置的油量 否则直接加满
            // 每遇到一个加油站都需要确定，如果能过跑到最近的低价加油站则不用加油，否则需要加到能过跑到最近便宜的加油站的油量

        }
    }
}
