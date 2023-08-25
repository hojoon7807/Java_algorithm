package programmers;

import java.util.Arrays;

public class 사칙연산 {

  public static void main(String[] args) {
    사칙연산 m = new 사칙연산();
    System.out.println(m.solution(new String[]{"1", "-", "3", "+", "5", "-", "8"}));
  }

  public int solution(String arr[]) {
    int[][] min = new int[201][201];
    int[][] max = new int[201][201];
    // + max[i][j] = max[i][k-1] + max[k+1][j];
    //   min[i][j] = min[i][k-1] + min[k+1][j];

    // - max[i][j] = max[i][k-1] - min[k+1][j];
    //   min[i][j] = min[i][k-1] - max[k+1][j];
    // max[0][2] = max[0][2], max[0][0] + max[2][2];
    // max[2][4] = max[2][4], max[2][2] + max[4][4];
    // max[0][4] = max[0][4], max[0][0] + max[2][4];
    // max[0][4] = max[0][4], max[0][2] + max[4][4];

    for (int i = 0; i < arr.length; i++) {
      Arrays.fill(max[i], Integer.MIN_VALUE);
      Arrays.fill(min[i], Integer.MAX_VALUE);
    }
    for (int len = 0; len < arr.length; len += 2) {
      for (int start = 0; start < arr.length - len; start += 2) {
        int end = start + len;

        if (len == 0) {
          max[start][end] = Integer.parseInt(arr[start]);
          min[start][end] = Integer.parseInt(arr[start]);
          continue;
        }

        for (int k = start + 1; k < end; k += 2) {
          String command = arr[k];

          if (command.equals("+")) {
            max[start][end] = Math.max(max[start][end], max[start][k - 1] + max[k + 1][end]);
            min[start][end] = Math.min(min[start][end], min[start][k - 1] + min[k + 1][end]);
          } else {
            max[start][end] = Math.max(max[start][end], max[start][k - 1] - min[k + 1][end]);
            min[start][end] = Math.min(min[start][end], min[start][k - 1] - max[k + 1][end]);
          }
        }
      }
    }

    return max[0][arr.length - 1];
  }

}
