package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class 코딩테스트공부 {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashSet<int[]> ints = new HashSet<>();
    ints.add(new int[]{1, 2, 3});
    ints.add(new int[]{1, 2, 3});

    System.out.println(ints);
  }
  
  public int solution(int alp, int cop, int[][] problems) {
    int maxAlp = 0;
    int maxCop = 0;

    for (int i = 0; i < problems.length; i++) {
      maxAlp = Math.max(problems[i][0], maxAlp);
      maxCop = Math.max(problems[i][1], maxCop);
    }

    if (maxAlp <= alp && maxCop <= cop) {
      return 0;
    }

    int[][] dp = new int[151][151];

    Arrays.fill(dp, Integer.MAX_VALUE);

    dp[alp][cop] = 0;

    for (int i = alp; i <= maxAlp; i++) {
      for (int j = cop; j <= maxCop; j++) {
        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
        dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

        for (int[] p : problems) {

          if (i >= p[0] && j >= p[1]) {
            if (i + p[2] > maxAlp && j + p[3] > maxCop) {
              dp[maxAlp][maxCop] = Math.min(dp[maxAlp][maxCop], dp[i][j] + p[4]);
            } else if (i + p[2] > maxAlp) {
              dp[maxAlp][j + p[3]] = Math.min(dp[maxAlp][j + p[3]], dp[i][j] + p[4]);
            } else if (j + p[3] > maxCop) {
              dp[i + p[2]][maxCop] = Math.min(dp[i + p[2]][maxCop], dp[i][j] + p[4]);
            } else if (i + p[2] <= maxAlp && j + p[3] <= maxCop) {
              dp[i + p[2]][j + p[3]] = Math.min(dp[i + p[2]][j + p[3]], dp[i][j] + p[4]);
            }
          }
        }

      }
    }
    return dp[maxAlp][maxCop];
  }
}
