package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] items = new int[N][2];
    int[] dp = new int[K+1];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());

      items[i] = new int[]{W, V};
    }

    for (int i = 0; i < N; i++) {
      for (int j = K; j - items[i][0] >= 0; j--) {
        dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
      }
    }

    System.out.println(dp[K]);
  }
}
