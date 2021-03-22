package chapter6.C;

import java.io.*;
import java.math.BigInteger;
/* 有时间最好会写进制转换函数
string conversion(int m, string a, int n){
    int l = a.size(),k=0;
    string b;
    for (int i = 0; i < l;){
        k = 0;
        for (int j = i; j <l; j++)//12345 / 2 变成  06172 那么下次跳过了数字为0的下标，从6开始 ,但是下标总是以n结束
        {
            int t = (k*m + a[j] - '0') % n;  //每次之和一位以及上一次的余数有关，向下传递一个余数
            a[j] = (k*m + a[j] - '0') / n+'0';
            k = t;
        }
        b += char(k + '0');
        while (a[i]=='0') i++;//跳过这一次产生的高位的0
    }
    return b;
}
int main()
{
    string a,b,c;
    while (cin >> a){
        b = conversion(10, a, 2);
        a = conversion(2, b, 10);
        reverse(a.begin(), a.end());
        cout << a << endl;
    }
}
 */
public class C3_c {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(
                    new BigInteger(
                    new StringBuilder(new BigInteger(line).toString(2)).reverse().toString(), 2)
                    .toString());
        }
    }
}
