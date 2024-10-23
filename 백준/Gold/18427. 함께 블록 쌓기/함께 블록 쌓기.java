import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, m, h;
  static int[][] dp;
  static int mod = 10_007;
  static ArrayList<ArrayList<Integer>> info = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    String[] nmh = br.readLine().split(" ");
    n = Integer.parseInt(nmh[0]);
    m = Integer.parseInt(nmh[1]);
    h = Integer.parseInt(nmh[2]);

    dp = new int[n + 1][h + 1];

    for (int i = 0; i <= n; i++) {
      info.add(new ArrayList<>());
    }

    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i <=n ; i++) {
      String[] input = br.readLine().split(" ");

      for (String s : input) {
        info.get(i).add(Integer.valueOf(s));
      }
    }

    for (int i = 1; i <=n; i++) {
      for (int j = 1; j <=h ; j++) {
        for (Integer height : info.get(i)) {
          if (j >= height) {
            dp[i][j] += dp[i - 1][j - height];
            dp[i][j] %= mod;
          }
        }

        dp[i][j] += dp[i-1][j];
        dp[i][j] %= mod;
      }
    }

    System.out.println(dp[n][h]);
  }

}
