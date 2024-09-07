
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  // 파사노 주기
  // M = 10^k 일 때, k > 2 라면, 주기는 항상 15 * 10^(k-1)

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static long n;
  static int mod = 1000000;
  static int p = 15 * (mod / 10);
  static int[] memo = new int[p];

  public static void main(String[] args) throws Exception{
    n = Long.parseLong(br.readLine());

    memo[0] = 0;
    memo[1] = 1;

    for (int i = 2; i <= n % p; i++) {
      memo[i] = (memo[i-1] + memo[i-2]) % mod;
    }

    int end = (int) (n % p);
    System.out.println(memo[end]);
  }

}
