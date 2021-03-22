package chapter9.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class C1_middle_answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(BFS(
                    Integer.parseInt(line.split(" ")[0]),
                    Integer.parseInt(line.split(" ")[1])
            ));
        }
    }
    private static final int MAX = 10001;
    // 三种状态
    // n 是位置，t 是时间
    // (n - 1, t + 1)
    // (n + 1, t + 1)
    // (n * 2, t + 1)
    private static class Status {
        int n, time;

        public Status(int n, int time) {
            this.n = n;
            this.time = time;
        }
    }
    // 宽度优先搜索
    // 实际上是遍历了所有的可能性
    private static int BFS(int n, int k) {
        Queue<Status> statuses = new LinkedList<Status>();
        // 压入初始状态
        statuses.add(new Status(n, 0));
        boolean[] visit = new boolean[MAX];
        // 初始状态已被访问
        visit[n] = true;
        while (!statuses.isEmpty()) {
            // 取出当前状态
            Status current = statuses.poll();
            // 抵达需要访问的节点
            if (current.n == k) {
                return current.time;
            }
            // 转入三个状态
            for (int i = 0; i < 3; i++) {
                Status next = new Status(current.n, current.time + 1);
                switch (i) {
                    case 0: next.n += 1; break;
                    case 1: next.n -= 1; break;
                    default: next.n *= 2;
                }
                // 状态不合法
                if (next.n < 0 || next.n >= MAX || visit[next.n]) {
                    continue;
                }
                // 压入新状态
                statuses.add(next);
                // 该节点已被访问
                visit[next.n] = true;
            }
        }
        return -1;
    }
}
