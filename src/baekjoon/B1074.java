package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1074 {
  static int R;
  static int C;
  static int count = 0;
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    R = Integer.parseInt(input[1]);
    C = Integer.parseInt(input[2]);

    int size =(int) Math.pow(2, N);

    visit(0, 0, size);
  }

  static void visit(int r, int c, int n) {
    if (n == 1) {
      System.out.println(count);
      return;
    }

    int divide = n/2;
    if (R < r+divide && C< c+divide) {
      visit(r, c, divide);
    }
    if (R < r + divide && C >= c + divide) {
      count += divide*divide*1;
      visit(r, c + divide, divide);
    }
    if (R >= r + divide && C < c + divide) {
      count += divide*divide*2;
      visit(r + divide, c, divide);
    }
    if (R >= r + divide && C >= c + divide) {
      count += divide*divide*3;
      visit(r + divide, c + divide, divide);
    }
  }
}
