package chapter3.C;

import java.io.*;
import java.util.*;

public class C3 {
    private static class Student implements Comparable<Student> {
        String name;
        int grade;

        @Override
        public int compareTo(Student o) {
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
            int flag = Integer.parseInt(br.readLine());
            students = new Student[times];
            int i = 0;
            while (times-- > 0) {
                str = br.readLine().split(" ");
                students[i] = new Student();
                students[i].name = str[0];
                students[i++].grade = Integer.parseInt(str[1]);
            }
            if (flag == 1) {
                Arrays.sort(students);
            } else {
                Arrays.sort(students, Collections.<Student>reverseOrder());
            }
            for (Student student : students) {
                System.out.println(student.name + " " + student.grade);
            }
        }
    }
}
