package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7579 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] split = br.readLine().split(" ");
    int N = Integer.parseInt(split[0]);
    int M = Integer.parseInt(split[1]);

    int[][] apps = new int[N][2];
    int[] dp = new int[10001];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      apps[i][0] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      apps[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      for (int j = 10000; j >= apps[i][1] ; j--) {
        dp[j] = Math.max(dp[j], dp[j - apps[i][1]] + apps[i][0]);
      }
    }

    for (int i = 0; i < 100001; i++) {
      if (dp[i] >= M) {
        System.out.println(i);
        break;
      }
    }
  }

}
