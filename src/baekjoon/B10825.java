package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10825 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    Student[] students = new Student[n];

    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      students[i] = new Student(
          input[0],
          Integer.parseInt(input[1]),
          Integer.parseInt(input[2]),
          Integer.parseInt(input[3])
      );
    }

    Arrays.sort(students);

    StringBuilder sb = new StringBuilder();

    for (Student student : students) {
      sb.append(student.name).append("\n");
    }

    System.out.println(sb);
  }

  static class Student implements Comparable<Student> {
    String name;
    int korean, english, math;

    public Student(String name, int korean, int english, int math) {
      this.name = name;
      this.korean = korean;
      this.english = english;
      this.math = math;
    }


    @Override
    public int compareTo(Student o) {
      if (this.korean != o.korean) {
        return o.korean - this.korean;
      }

      if (this.english != o.english) {
        return this.english - o.english;
      }

      if (this.math != o.math) {
        return o.math - this.math;
      }

      return this.name.compareTo(o.name);
    }
  }

}
