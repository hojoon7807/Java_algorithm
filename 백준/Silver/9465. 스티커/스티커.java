import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int t,n;
  static int[][] arr;
  static int[][] dp;
  static StringBuilder sb = new StringBuilder();
  /*
  arr[][]

  dp[][]

  스티커를 뗄 수 있는 경우
  0,0 을 뗐다면 1,1 or 0,2 를 뗄수 있다
  dp[i][j] = max(dp[i-1][j-1], dp[i-1][j-2]) + arr[i][j]

   */
  public static void main(String[] args) throws IOException {
    t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      init();
      dp();
    }

    System.out.println(sb);
  }

  static void init() throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = new int[2][n];

    for (int i = 0; i < 2; i++) {
      arr[i] = Arrays.stream(br.readLine().split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
  }

  static void dp(){
    dp = new int[2][n + 1];

    dp[0][1] = arr[0][0];
    dp[1][1] = arr[1][0];

    for (int i = 2; i <= n; i++) {
      dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i - 1];
      dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i - 1];
    }

    sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
  }

}
