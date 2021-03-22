package chapter3.C;

import java.io.*;
import java.util.Arrays;

public class C2 {
    private static class Student implements Comparable<Student> {
        int sno;
        int grade;

        @Override
        public int compareTo(Student o) {
            if (grade == o.grade) {
                return sno - o.sno;
            }
            return grade - o.grade;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] str;
        Student[] students;
        while ((line = br.readLine()) != null) {
            int times = Integer.parseInt(line);
            int i = 0;
            students = new Student[times];
            while (times-- > 0) {
                str = br.readLine().split(" ");
                students[i] = new Student();
                students[i].sno = Integer.parseInt(str[0]);
                students[i++].grade = Integer.parseInt(str[1]);
            }
            Arrays.sort(students);
            for (Student student : students) {
                System.out.println(student.sno + " " + student.grade);
            }
        }
    }
}
