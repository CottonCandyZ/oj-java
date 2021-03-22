package chapter5.C;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class C5_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            char[] result = new char[line.length()];
            Arrays.fill(result, ' ');
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '(') {
                    stack.push(i);
                } else if (c == ')') {
                    if (stack.isEmpty()) result[i] = '?';
                    else stack.pop();
                }
            }
            while (!stack.isEmpty()) {
                result[stack.pop()] = '$';
            }
            System.out.println(result);
        }
    }
}
/*
)(rttyy())sss)(
 */