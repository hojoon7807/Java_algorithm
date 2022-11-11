package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15724 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");

    int N = Integer.parseInt(NM[0]);
    int M = Integer.parseInt(NM[1]);

    int[][] map = new int[N + 1][M + 1];
    int[][] dp = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 1; j <= M; j++) {
        map[i][j] = Integer.parseInt(input[j-1]) + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
      }
    }

    int K = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < K; i++) {
      String[] range = br.readLine().split(" ");
      int x1 = Integer.parseInt(range[0]);
      int y1 = Integer.parseInt(range[1]);
      int x2 = Integer.parseInt(range[2]);
      int y2 = Integer.parseInt(range[3]);

      int result = map[x2][y2] - map[x2][y1 - 1] - map[x1 - 1][y2] + map[x1 - 1][y1 - 1];
      sb.append(result + "\n");
    }
    System.out.println(sb);
//    for (int i = 1; i <= N; i++) {
//      dp[i][1] = map[i][1];
//    }
//
//    for (int i = 1; i <=N; i++) {
//      for (int j = 2; j <=M; j++) {
//        dp[i][j] = dp[i][j - 1] + map[i][j];
//      }
//    }
//    int K = Integer.parseInt(br.readLine());
//
//    for (int i = 0; i < K; i++) {
//      String[] range = br.readLine().split(" ");
//      int x1 = Integer.parseInt(range[0]);
//      int y1 = Integer.parseInt(range[1]);
//      int x2 = Integer.parseInt(range[2]);
//      int y2 = Integer.parseInt(range[3]);
//      int sum = 0;
//      for (int j = x1; j <= x2 ; j++) {
//        sum += dp[j][y2] - dp[j][y1-1];
//      }
//      System.out.println(sum);
//    }
//  }

  }
}
