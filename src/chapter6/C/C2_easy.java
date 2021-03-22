package chapter6.C;

import java.io.*;
import java.math.BigInteger;
// 可以直接使用 System.out.println(new BigInteger(line, 10).toString(2));
// 讨论中包含了一个竖式除法，值得一看，书上也采用了类似的方法
/*
#include <stdio.h>
#include <string.h>
using namespace std;

int main(){
    char str[31];
    int  num[31];
    int res[2000];

    while(scanf("%s",str)!=EOF){  //字符串转数字
        for(int i=0;i<strlen(str);i++)
            num[i]=str[i]-'0';

        int size=strlen(str);
        int index=0;//结果数组游标

        for(int i=0;i<size;){ //控制被除数开始位置
            int temp=0,remain=0;//余数
            for(int j=i;j<size;j++){ //控制除法运算，竖式除法，从头往后每一位依次作除法
                temp=(10*remain+num[j])%2;
                num[j]=(10*remain+num[j])/2;
                remain=temp;
            }
            res[index]=remain;
            index++;
            while(num[i]==0) //从第一个非0开始
                i++;
        }

        for(int i=index-1;i>=0;i--) { //逆序输出
            printf("%d",res[i]);
        }

            printf("\n");
    }
}
 */
public class C2_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            BigInteger integer = new BigInteger(line);
            while (integer.compareTo(new BigInteger("0")) > 0) {
                sb.append(integer.mod(new BigInteger("2")));
                integer = integer.shiftRight(1);
            }
            System.out.println(sb.reverse().toString());
        }
    }
}
