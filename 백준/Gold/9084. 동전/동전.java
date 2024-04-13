import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int t;
  static int n,m;
  static int[] coins;
  
  /*
  3번 문제 동전과 똑같다
  T 개수 만큼 결과를 넣어 출력
   */

  public static void main(String[] args) throws IOException {
    t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());
      coins = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();
      m = Integer.parseInt(br.readLine());

      dp();
    }

    System.out.println(sb);
  }

  static void dp(){
    int[] dp = new int[m + 1];
    dp[0] = 1;

    for (int i = 0; i < n; i++) {
      for (int j = coins[i]; j <= m; j++) {
        dp[j] += dp[j - coins[i]];
      }
    }

    sb.append(dp[m]).append("\n");
  }

}
