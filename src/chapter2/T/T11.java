package chapter2.T;
// 难题
// https://www.nowcoder.com/practice/fdd6698014c340178a8b1f28ea5fadf8?tpId=40&tqId=21420&tPage=1&rp=1&ru=%2Fta%2Fkaoyan&qru=%2Fta%2Fkaoyan%2Fquestion-ranking&tab=answerKey
/*本题最重要的逻辑是蚂蚁的相对位置永远不变！！这个逻辑直接推导出了本题的解法之一
 有参考 http://www.cnblogs.com/liangrx06/p/5083868.html
  不过因为没有注解，所以自己写了一点
首先，我们来确定怎么判断蚂蚁不会坠落，有两种情况————
   第一种：静止的蚂蚁两边的蚂蚁都不会碰到这只蚂蚁，也就是说，左边的往左走，右边的往右走
   第二种：蚂蚁的右边有向左走的，左边有向右走的，按照一般的理解一开始静止的蚂蚁一定
   是会掉下去的，但是注意一开始提到的那个逻辑，**蚂蚁的相对位置不变，并且移动方向也不变！**
   什么意思呢，比如整个树枝上向左走有n个，向右走有m个。那么在任何时间向左走和向右走的
   数量都是n和m，这时候结合蚂蚁的相对位置，在无限的时刻，向左走的n只蚂蚁都掉下了树枝，
   这n只不一定都是原来初始状态向左走的，但一定是一开始左边的n只蚂蚁，因为相对位置不变。
   同理，右边m只也都掉出去了，那么如果n==m，并且静止的蚂蚁左右都有n(m)只。那么，在某个时刻，
   左边n只无论之前是向哪里走的，一定都下去了。
   所以，我们把结论推广，**只要静止的蚂蚁左边的蚂蚁数量，等于所有蚂蚁中往左走的数量，
   亦或者右边的等于向右走的那么它就不会掉下去。**

那么，怎么判断蚂蚁什么时候下去呢
   这时候肯定能确定这只蚂蚁左右数量不等了。接下来就是很巧妙的思想了，如果该蚂蚁
   左边的蚂蚁数量小于向左走的蚂蚁数量,那么它总会加入向左走的大军最后掉落。这时候
   我们宏观的去看，我们定位所有在向左走的蚂蚁，并且定位静止的那只蚂蚁的位置，并且
   标记为k(第k个蚂蚁)，这时开始移动，我们看不到蚂蚁之间交换速度，我们只知道他们
   像是穿过对方继续往下走。让蚂蚁继续走，直到某一刻我们观察到第k只向左走的蚂蚁
   掉下去了，暂停。现在考虑所有蚂蚁的相对位置不变！如果是第k个向左走的蚂蚁下去了
   那么他之前的向左走的蚂蚁都下去了，反映到相对位置上来说，就是树枝上左边k-1只都下去了，
   那么这一瞬间掉下去的想必就是相对位置在第k的蚂蚁了————也就是原来静止的那只。
   也就是说一开始所有向左走的蚂蚁中，第k个蚂蚁要走多远，就是最终答案！！
   同样，如果反过来，右边的少于向右走的，也一样，

   假设静止的蚂蚁在第 k 个位置，那么需要找到 向左走的第 k 个
*/
import java.io.*;
import java.util.Arrays;
// 参考讨论

public class T11 {
    private static class Ant implements Comparable<Ant> {
        int pos;
        int direct;

        @Override
        public int compareTo(Ant o) {
            return this.pos - o.pos;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int times = Integer.parseInt(str);
            Ant[] ants = new Ant[times];
            int i = 0;
            while (times-- > 0) {
                str = br.readLine();
                ants[i] = new Ant();
                ants[i].pos = Integer.parseInt(str.split(" ")[0]);
                ants[i++].direct = Integer.parseInt(str.split(" ")[1]);
            }
            answer(ants);
        }
    }
    private static void answer(Ant[] ants) {
        Arrays.sort(ants);
        int target = 0, toLeft = 0;
        for (int i = 0; i < ants.length; i++) {
            if (ants[i].direct == 0)
                target = i;
            if (ants[i].direct == -1)
                toLeft++;
        }
        int distance = 0;
        int cnt = 0;
        if (toLeft == target) {
            System.out.println("Cannot fall!");
            return;
        } else if (toLeft > target) {
            // 找到向左走的第 target 个
            // 记录下它离边缘的距离
            for (Ant ant : ants) {
                if (ant.direct == -1) {
                    if (cnt == target) {
                        distance = ant.pos;
                        break;
                    }
                    cnt++;
                }
            }
        } else {
            for (int i = ants.length - 1; i >= 0; i--) {
                if (ants[i].direct == 1) {
                    if (cnt == ants.length - target - 1) {
                        distance = 100 - ants[i].pos;
                        break;
                    }
                    cnt++;
                }
            }
        }
        System.out.println(distance);
    }
}
