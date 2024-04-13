import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, k;
  static int[] dp;
  static int[] arr;

  /*
  k 크기의 dp 배열
  dp[i] = i를 만들 수 있는 경우의 수
  arr = 동전 입력 배열


   */
  public static void main(String[] args) throws IOException {
    String[] nk = br.readLine().split(" ");
    n = Integer.parseInt(nk[0]);
    k = Integer.parseInt(nk[1]);

    arr = new int[n];
    dp = new int[k + 1];

    for (int i = 0; i < n; i++) {
      int v = Integer.parseInt(br.readLine());
      arr[i] = v;

    }

    dp[0] = 1;

    for (int i = 0; i < n; i++) {
      // arr[i] 동전으로 K 번까지 만들 수 있는 경우의 수 체크
      int cur = arr[i];
      for (int j = cur; j <= k; j++) {
        dp[j] += dp[j - cur];
      }
    }

    System.out.println(dp[k]);
  }

}
