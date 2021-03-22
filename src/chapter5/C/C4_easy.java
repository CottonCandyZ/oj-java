package chapter5.C;

import sun.security.util.ArrayUtil;

import java.io.*;
import java.util.Collections;
import java.util.Stack;
// new StringBuilder(hi).reverse().toString()
// java reverse String
public class C4_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        while (br.readLine() != null) {
            line = br.readLine().split(" ");
            Stack<String> stack = new Stack<String>();
            for (String s : line) {
                stack.push(s);
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }
}
