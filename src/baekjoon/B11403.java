package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11403 {
  static int n;
  static int[][] isVisited;
  static int[][] graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    isVisited = new int[n][n];
    graph = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(input[j]);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (isVisited[i][j] != 1 && graph[i][j] == 1) {
          makePath(i,j);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(isVisited[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static void makePath(int from, int to) {
    isVisited[from][to] = 1;

    for (int i = 0; i < n; i++) {
      if (graph[to][i] == 1) {
        if (isVisited[from][i] == 0) {
          makePath(from, i);
        }

        if (isVisited[to][i] == 0) {
          makePath(to, i);
        }
      }
    }

  }
}
