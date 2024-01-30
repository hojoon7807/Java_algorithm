package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16974 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static long X;

  public static void main(String[] args) throws IOException {
    input();
    solution();
  }

  static void input() throws IOException {
    String[] nx = br.readLine().split(" ");
    N = Integer.parseInt(nx[0]);
    X = Long.parseLong(nx[1]);
  }

  static void solution() {
    // L-0 P 1
    // l-1 BPPPB 5
    // l-2 B(L-1)P(L-1)B / B BPPPB P BPPPB B / BBPPPBPBPPPBB / 3+10 13
    // L-3 B(L-2)P(L-2)B / B BBPPPBPBPPPBB P BBPPPBPBPPPBB B 3+26 29
    // 1 5 13 29 61 125
    //
    // L-n = B (L-n-1) P (L-n-1) B / B(B(L-n-2)P(L-n-2)B)P(B(L-n-2)P(L-n-2)B)B / 3+2*(L-n-1)
    long[] burger = new long[N + 1];
    long[] patty = new long[N + 1];

    burger[0] = 1;
    patty[0] = 1;

    for (int i = 1; i <= N; i++) {
      burger[i] = burger[i - 1] * 2 + 3;
      patty[i] = patty[i - 1] * 2 + 1;
    }

    long answer = eat(N, X, burger, patty);
    System.out.println(answer);
  }

  static long eat(int n, long x, long[] burger, long[] patty) {
    if (n == 0) {
      return x;
    }

    if (n >= x) {
      return 0;
    }

    if (x <= 1 + burger[n - 1]) {
      return eat(n - 1, x - 1, burger, patty);
    }

    if (x == 1 + burger[n - 1] + 1) {
      return patty[n - 1] + 1;
    }

    if (x <= burger[n - 1] * 2 + 2) {
      return patty[n - 1] + 1 + eat(n - 1, x - (burger[n - 1] + 2), burger, patty);
    }

    return patty[n];
  }

}
