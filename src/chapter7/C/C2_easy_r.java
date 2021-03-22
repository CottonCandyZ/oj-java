package chapter7.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 通过 获得量 / 花费量 排序就可以计算出最具「性价比的产品」
// 优先购买具有性价比的
// 余下的钱就用来购买剩下的

public class C2_easy_r {
    private static class JavaBean implements Comparable<JavaBean> {
        public JavaBean(double weight, double cost) {
            this.weight = weight;
            this.cost = cost;
        }

        double weight;
        double cost;

        @Override
        public int compareTo(JavaBean o) {
            return Double.compare(o.weight / o.cost, weight / cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("-1 -1")) return;
            int N = Integer.parseInt(line.split(" ")[0]);
            int times = Integer.parseInt(line.split(" ")[1]);
            JavaBean[] javaBeans = new JavaBean[times];
            for (int i = 0; i < times; i++) {
                line = br.readLine();
                javaBeans[i] = new JavaBean(
                        Integer.parseInt(line.split(" ")[0]),
                        Integer.parseInt(line.split(" ")[1]));
            }
            Arrays.sort(javaBeans);
            double sum = 0;
            for (int i = 0; i < javaBeans.length; i++) {
                if (javaBeans[i].cost <= N) {
                    // 性价比高的全部买下
                    N -= javaBeans[i].cost;
                    sum += javaBeans[i].weight;
                } else {
                    // 还剩一点钱，买下余下的部分
                    if (N > 0) {
                        sum +=  (double) N * (javaBeans[i].weight / javaBeans[i].cost);
                    }
                    break;
                }
            }

            System.out.printf("%.3f\n", sum);
        }
    }
}
