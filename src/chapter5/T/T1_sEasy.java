package chapter5.T;

import java.io.*;
import java.util.Stack;
// 比较 String 时可以使用 contentEquals
public class T1_sEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("0")) return;
            int times = Integer.parseInt(line);
            Stack<String> stack = new Stack<String>();
            String[] str;
            while (times-- > 0) {
                str = br.readLine().split(" ");
                if (str[0].contentEquals("A")) {
                    if (stack.isEmpty()) System.out.println("E");
                    else System.out.println(stack.peek());;
                } else if (str[0].contentEquals("P")) {
                    stack.push(str[1]);
                } else {
                    if(!stack.isEmpty()) stack.pop();
                }
            }
            System.out.println();
        }
    }
}
/*
88
A
A
A
P 74
O
O
A
P 7
P 4
P 79
P 73
A
A
P 93
A
O
O
A
A
P 38
P 76
O
O
P 94
P 94
A
P 6
O
A
O
O
O
O
P 72
O
P 55
P 93
P 86
P 41
O
P 37
A
P 77
A
O
O
P 34
P 84
A
P 34
A
A
A
A
A
P 13
P 62
A
P 88
P 67
O
P 92
P 100
O
O
A
A
P 37
O
O
P 33
P 46
A
A
O
P 35
P 33
P 46
A
A
O
P 33
P 40
P 85
O
P 85
P 5
A
 */