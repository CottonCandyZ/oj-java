package chapter9.T;

import java.io.*;

public class T2_easy_DFS {
    private static int[] goods;
    private static int n;
    private static int num;
    private static final int capacity = 40;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            n = Integer.parseInt(line);
            goods = new int[n];
            for (int i = 0; i < n; i++) {
                goods[i] = Integer.parseInt(br.readLine());
            }
            num = 0;
            DFS(0, 0);
            System.out.println(num);
        }
    }

    // 确认状态
    // (sum, index)
    // sum 总和
    // num 方式数目
    // index 到第几个了
    private static void DFS(int sum, int index) {
        if (sum == capacity) {
            num++;
            return;
        }
        for (int i = index; i < n; i++) {
            DFS(sum + goods[i], i + 1);
        }
    }
}

/*
动态规划
include <stdio.h>
#define N 801

int main()
{
    int a, n;
    int method[N];//method[i]表示i有几种凑法
    while(scanf("%d", &n)!=EOF)
    {
        for(int i=0; i<N; i++)
        {
            method[i]=0;
        }
        method[0]=1;
        for(int i=0; i<n; i++)
        {
            scanf("%d", &a);
            for(int j=N-1; j>=a; j--)
            {
                method[j]+=method[j-a];
            }
        }
        printf("%d\n", method[40]);
    }
    return 0;
}
 */