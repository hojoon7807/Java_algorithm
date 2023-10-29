package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17070 {

  private static int[][] map;
  private static int count = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    String[] input;
    for (int i = 0; i < N; i++) {
      input = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(input[j]);
      }
    }

    int[] point = {0, 1};
  }

}
