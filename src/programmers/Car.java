package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Car {
  static int[] yArr = new int[1000001];
  static int[] xArr = new int[1000001];

  static int[][] input = new int[][]{{0, 2, 1, 3}, {1, 2, 2, 5}, {3, 3, 4, 4}, {4, 1, 6, 3},
      {1, 6, 5, 7}, {5, 5, 7, 6}, {5, 8, 6, 10}};

  public static void main(String[] args) {

    String[] solution = solution(input);
    System.out.println(Arrays.toString(solution));
  }

  public static String[] solution(int[][] input) {
    int[][] clone = new int[input.length][4];
    for (int i = 0; i < input.length; i++) {
      clone[i] = input[i];
    }
    Arrays.sort(clone, Comparator.comparingInt(arr -> arr[1]));

    for (int[] ints : clone) {
      int w = ints[2] - ints[0];
      int h = ints[3] - ints[1];

      int startX = ints[0];
      int diff = 0;
      for (int i = startX; i < startX + w; i++) {
        if (i == startX) {
          yArr[i] += h;

          diff = ints[3] - yArr[i];
          ints[3] -= diff;
          ints[1] -= diff;
        } else {
          yArr[i] = yArr[i-1];
        }
      }
    }

    for (int i = 0; i < input.length; i++) {
      clone[i] = input[i];
    }

    Arrays.sort(clone, Comparator.comparingInt(arr -> arr[0]));

    for (int[] ints : clone) {
      int w = ints[2] - ints[0];
      int h = ints[3] - ints[1];

      int startY = ints[1];
      int diff = 0;
      for (int i = startY; i < startY + h; i++) {
        if (i == startY) {
          xArr[i] += w;

          diff = ints[2]- xArr[i] ;
          ints[2] -= diff;
          ints[0] -= diff;
        } else {
          xArr[i] = xArr[i-1];
        }
      }
    }

    String[] result = new String[input.length];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      int[] ints = input[i];
      sb.append("\"").append(ints[0]).append(" ").append(ints[1]).append(" ").append(ints[2])
        .append(" ").append(ints[3]).append("\"");
      result[i] = sb.toString();
      sb = new StringBuilder();
    }

    return result;
  }

  public class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
