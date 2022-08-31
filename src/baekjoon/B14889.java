package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0);

    System.out.println(min);
  }

  static void dfs(int index, int depth) {
    if (depth == N / 2) {
      cal();
      return;
    }

    for (int i = index; i < N; i++) {
      if (!isVisited[i]) {
        isVisited[i] = true;
        dfs(i + 1, depth + 1);
        isVisited[i] = false;
      }
    }
  }

  static void cal() {
    int start = 0;
    int link = 0;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (isVisited[i] && isVisited[j]) {
          start += (arr[i][j] + arr[j][i]);
        } else if (!isVisited[i] && !isVisited[j]) {
          link += (arr[i][j] + arr[j][i]);
        }
      }
    }
    int val = Math.abs(start - link);

    if (val == 0) {
      System.out.println(val);
      System.exit(0);
    }

    min = Math.min(val, min);
  }

}
