import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, k;
  static int mod = 1_000_000_003;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());

    if (n / 2 < k) {
      System.out.println(0);
      return;
    }

    dp = new int[n + 1][k + 1];

    /**
     * dp[i][j] = i개의 색을 j개 선택하는 경우의 수
     * 1번색을 선택하면 양쪽 2개의 색을 선택하지 못함 dp[i-3][k-1] -> n,1,2는 선택 불가
     * 1번색을 선택하지 않으면 dp[i-1][k] -> 1번을 제외한 색 중 k 개를 뽑는 경우
     *
     */

    for (int i = 1; i <= n; i++) {
      // i개 중 1개 선택 방법 -> i개
      // i개 중 선택하지 않는 방법 -> 1개
      dp[i][0] = 1;
      dp[i][1] = i;
    }

    for (int i = 3; i <= n; i++) {
      for (int j = 2; j <= k; j++) {
        dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % mod;
      }
    }

    int answer = (dp[n - 3][k - 1] + dp[n - 1][k]) % mod;

    System.out.println(answer);
  }

}
