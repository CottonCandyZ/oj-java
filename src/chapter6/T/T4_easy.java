package chapter6.T;

import java.io.*;
public class T4_easy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(
                    Long.toString(
                            Long.parseLong(line.split(" ")[1], Integer.parseInt(line.split(" ")[0]))
                            , Integer.parseInt(line.split(" ")[2])).toUpperCase()
            );
        }
    }
}

