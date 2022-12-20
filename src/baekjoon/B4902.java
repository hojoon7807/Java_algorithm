package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B4902 {

  static int[][] triangle;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = "";
    while ((s = br.readLine()) != null && !s.equals("0")) {
      StringTokenizer st = new StringTokenizer(s);
      int line = Integer.parseInt(st.nextToken());
      int col = 2*line - 1;
      triangle = new int[line][col];

      for (int i = 0; i < line; i++) {
        for (int j = 0; j < (i+1)*2-1; j++) {
          triangle[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < line; i++) {
        System.out.println(Arrays.toString(triangle[i]));
      }
    }

  }

}
