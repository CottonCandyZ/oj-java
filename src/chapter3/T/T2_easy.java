package chapter3.T;


import java.io.*;
import java.util.*;

public class T2_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] str = line.split(" ");
            ArrayList<Integer> odd = new ArrayList<Integer>();
            ArrayList<Integer> even = new ArrayList<Integer>();
            for (String s : str) {
                int temp = Integer.parseInt(s);
                if (temp % 2 == 1) {
                    odd.add(temp);
                } else {
                    even.add(temp);
                }
            }
            Collections.sort(odd, Collections.<Integer>reverseOrder());
            Collections.sort(even);
            for (Integer integer : odd) {
                System.out.print(integer + " ");
            }
            for (Integer integer : even) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
