package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B1377 {

    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      Point[] points = new Point[N];
      for (int i = 0; i < N; i++) {
        int temp = Integer.parseInt(br.readLine());
        points[i] = new Point(temp, i);
      }
      Arrays.sort(points, Comparator.comparingInt(o -> o.num));

      int max = 0;
      for (int i = 0; i < N; i++) {
        max = Math.max(max, points[i].idx - i);
      }

      System.out.println(max+1);
    }

  static class Point{
    int num;
    int idx;

    Point(int num, int idx) {
      this.num = num;
      this.idx = idx;
    }
  }


}
