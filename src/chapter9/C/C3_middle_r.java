package chapter9.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 先确认状态
// (x, y, step)
// 分别为所在坐标和步数
// 还需要一个标记数组来确认状态
public class C3_middle_r {
    private static int p; // 对应 x
    private static int q; // 对应 y
    private static int sum;
    private static boolean[][] visit;
    private static final int[][] direction = {
            {-1, -2}, {1, -2}, {-2, -1}, {2, -1}, {-2, 1}, {-2, 1}, {2, 1}, {-1, -2}, {1, 2}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        String[] line;
        for (int i = 0; i < times; i++) {
            line = br.readLine().split(" ");
            // 获得 棋盘大小
            p = Integer.parseInt(line[0]);
            q = Integer.parseInt(line[1]);
            sum = p * q;
            visit = new boolean[p][q];
            // 开始位置
            visit[0][0] = true;
            System.out.println("Scenario #" + (i + 1) + ":");
            if (!DFS(0, 0, 1, "A1")) {
                System.out.println("impossible");
            }
            System.out.println();
        }
    }

    /**
     * 深度搜索
     * @param x, y 起点坐标
     * @param step 步数
     * @param ans 起始 (0, 0) 对应 A1，其中 A 为列，1为行
     * @return 是否可以完全访问完
     */
    private static boolean DFS(int x, int y, int step, String ans) {
        if (step == sum) {
            System.out.println(ans);
            return true;
        }
        // 总共 8 个方向，8 种状态
        for (int i = 0; i < 8; i++) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            char col = (char) (ny + 'A');
            char row = (char) (nx + '1');
            // 越界判断
            if (nx < 0 || nx >= p || ny < 0 || ny >= q || visit[nx][ny]) {
                continue;
            }
            // 更新标记
            visit[nx][ny] = true;
            if (DFS(nx, ny, step + 1, ans + col + row)) {
                // 成了
                return true;
            }
            // 不通，还原
            visit[nx][ny] = false;
        }
        return false;
    }

}
