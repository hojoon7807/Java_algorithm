import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int[][] w;
  static int[][] dp;
  static int INF = 123456789;

  public static void main(String[] args) throws Exception {
    n = Integer.parseInt(br.readLine());
    w = new int[n][n];

    for (int i = 0; i < n; i++) {
      w[i] = Arrays.stream(br.readLine().split(" "))
                   .mapToInt(Integer::parseInt)
                   .toArray();
    }

    dp = new int[n][1 << n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }

    System.out.println(tsp(0, 1));
  }

  static int tsp(int start, int visited) {
    if (visited == (1 << n) - 1) {
      return w[start][0] == 0 ? INF : w[start][0];
    }

    if (dp[start][visited] != -1) {
      return dp[start][visited];
    }

    dp[start][visited] = INF;

    for (int i = 1; i < n; i++) {
      if ((visited & (1 << i)) == 0 && w[start][i] != 0) {
        dp[start][visited] = Math.min(dp[start][visited], tsp(i, visited | (1 << i)) + w[start][i]);
      }
    }

    return dp[start][visited];
  }
}
