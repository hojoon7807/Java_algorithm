package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1015 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    int[] b = new int[1001];
    int[] p = new int[n];

    String[] input = br.readLine().split(" ");

    for (int i = 0; i < n; i++) {
      int value = Integer.parseInt(input[i]);
      a[i] = value;
      b[value]++;
    }

    b[0] --;

    for (int i = 1; i <= 1000; i++) {
      b[i] += b[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
      p[i] = b[a[i]]--;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(p[i]).append(" ");
    }

    System.out.println(sb);

    // b[p[1]]= arr[1]
    // 1, 2, 0
    // b[1] = 2 b[2] = 3  b[0] = 1
  }

}
