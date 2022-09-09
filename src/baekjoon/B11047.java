package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11047 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NK = br.readLine().split(" ");
    int N = Integer.parseInt(NK[0]);
    int k = Integer.parseInt(NK[1]);

    int[] A = new int[N];

    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(br.readLine());
    }

    int count = 0;

    if (N == 1) {
      count = k;
      System.out.println(count);
      return;
    }

    for (int i = N - 1; i >= 0; i--) {
      count += k / A[i];
      k %= A[i];

      if (k == 0) {
        break;
      }
    }
    System.out.println(count);
  }
}
