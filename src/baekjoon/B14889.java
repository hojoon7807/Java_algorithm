package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14889 {

  static int[][] arr;
  static int N;
  static boolean[] isVisited;

  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    arr = new int[N][N];
    isVisited = new boolean[N];

    for (int i = 0; i < N; i++) {
      String[] strings = br.readLine().split(" ");

      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(strings[j]);
      }
    }

    dfs(0, 0);

    System.out.println(min);
  }

  private static void dfs(int num, int depth) {
    if (depth == N / 2) {
      cal();
      return;
    }

    for (int i = num; i < N; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        dfs(num + 1, depth + 1);
        isVisited[i] = false;
      }
    }
  }

  static void cal() {
    int start = 0;
    int link = 0;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (isVisited[i] == true && isVisited[j] == true) {
          start += arr[i][j];
          start += arr[j][i];
        } else if (isVisited[i] == false && isVisited[j] == false) {
          link += arr[i][j];
          link += arr[j][i];
        }
      }
    }
    int val = Math.abs(start - link);

    if (val == 0) {
      System.out.println(val);
    }

    min = Math.min(val, min);
  }

}
