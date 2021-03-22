import java.io.*;
// https://github.com/zguolee/WDAlgorithmsNote
public class Test {
    public static void main(String[] args) throws IOException {
        String[][] temp = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                temp[i][j] = "(" + i + ", " + j + ")";
            }
        }
        for (String[] strings : temp) {
            for (String string : strings) {
                System.out.print(string + "  ");
            }
            System.out.println();
        }
    }
}
