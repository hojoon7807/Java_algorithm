package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1956 {

  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] VE = br.readLine().split(" ");

    int V = Integer.parseInt(VE[0]);
    int E = Integer.parseInt(VE[1]);

    int INF = 987654321;
    dp = new int[V][V];


    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (i != j) {
          dp[i][j] = INF;
        }
      }
    }

    for (int i = 0; i < E; i++) {
      String[] input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);
      int c = Integer.parseInt(input[2]);

      dp[a-1][b-1] = c;
    }

    for (int k = 0; k < V; k++) {
      for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
          if (i == j) {
            continue;
          }
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        }
      }
    }

    int answer = INF;
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (i == j) {
          continue;
        }
        if (dp[i][j] != INF && dp[j][i] != INF) {
          answer = Math.min(answer ,dp[i][j] + dp[j][i]);
        }
      }
    }
    System.out.println(answer == INF ? -1 : answer);
  }

}
