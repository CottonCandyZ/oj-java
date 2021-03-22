package chapter4.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Character.getNumericValue() 将 char 转为 int
public class C1_easy_c {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String firstS = line.split(" ")[0];
            String secondS = line.split(" ")[1];
            int sum = 0;
            for (int i = 0; i < firstS.length(); i++) {
                for (int j = 0; j < secondS.length(); j++) {
                    sum += Character.getNumericValue(firstS.charAt(i)) *
                            Character.getNumericValue(secondS.charAt(j));
                }
            }
            System.out.println(sum);
        }
    }
}
