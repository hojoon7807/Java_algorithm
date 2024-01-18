package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1106 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int n, c;
  static int[] prices, customers;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    c = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    prices = new int[n + 1];
    customers = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());

      prices[i] = Integer.parseInt(st.nextToken());
      customers[i] = Integer.parseInt(st.nextToken());
    }
  }

  static void solution() {
    int[] dp = new int[100001];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= 100000; j++) {
        int customer = customers[i];
        int price = prices[i];

        if (j - price >= 0) {
          dp[j] = Math.max(dp[j], dp[j - price] + customer);
        }
      }
    }

    for (int i = 1; i <= 100000; i++) {
      if (dp[i] >= c) {
        System.out.println(i);
        return;
      }
    }
  }

}
