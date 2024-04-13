import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[] dp = new int[31];

  /*
  3 * n 의 벽을 2 * 1, 1 * 2로 채우는 경우의 수


   */
  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());

    dp[0] = 1;
    dp[2] = 3;

    for (int i = 4; i <= n; i+=2) {
      dp[i] = dp[i-2] * 3;
      for (int j = 4; j <= i; j+=2) {
        dp[i] += dp[i-j] * 2;
      }
    }

    System.out.println(dp[n]);

  }

}
